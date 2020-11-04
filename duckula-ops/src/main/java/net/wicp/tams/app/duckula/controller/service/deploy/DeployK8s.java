package net.wicp.tams.app.duckula.controller.service.deploy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1Status;
import net.wicp.tams.app.duckula.controller.bean.models.CommonCheckpoint;
import net.wicp.tams.app.duckula.controller.bean.models.CommonInstance;
import net.wicp.tams.app.duckula.controller.bean.models.CommonMiddleware;
import net.wicp.tams.app.duckula.controller.bean.models.CommonTask;
import net.wicp.tams.app.duckula.controller.bean.models.CommonVersion;
import net.wicp.tams.app.duckula.controller.config.ConfigItem;
import net.wicp.tams.app.duckula.controller.config.constant.CommandType;
import net.wicp.tams.app.duckula.controller.config.constant.DeployType;
import net.wicp.tams.app.duckula.controller.config.constant.MiddlewareType;
import net.wicp.tams.app.duckula.controller.dao.CommonCheckpointMapper;
import net.wicp.tams.app.duckula.controller.dao.CommonInstanceMapper;
import net.wicp.tams.app.duckula.controller.dao.CommonMiddlewareMapper;
import net.wicp.tams.app.duckula.controller.dao.CommonTaskMapper;
import net.wicp.tams.app.duckula.controller.dao.CommonVersionMapper;
import net.wicp.tams.app.duckula.controller.service.K8sService;
import net.wicp.tams.common.Result;
import net.wicp.tams.common.beans.Host;

/***
 * 服务名要与DeployType同名
 * 
 * @author Andy.zhou
 *
 */
@Service("k8s")
public class DeployK8s implements IDeploy {
	@Autowired
	private K8sService k8sService;
	@Autowired
	private CommonTaskMapper commonTaskMapper;
	@Autowired
	private CommonMiddlewareMapper commonMiddlewareMapper;
	@Autowired
	private CommonInstanceMapper commonInstanceMapper;
	@Autowired
	private CommonVersionMapper commonVersionMapper;
	@Autowired
	private CommonCheckpointMapper commonCheckpointMapper;

	@Override
	public Result checkExit(Long deployid, CommandType taskType, Long taskId) {
		String configName = null;
		switch (taskType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			configName = taskType.formateConfigName(selectTask.getName());
			break;
		default:
			break;
		}
		try {
			V1ConfigMap selectConfigMap = k8sService.selectConfigMap(deployid, configName);
			if (selectConfigMap == null) {
				return Result.getError("查找失败");
			} else {
				return Result.getSuc();
			}
		} catch (Throwable e) {
			return Result.getError("查找异常:" + e.getMessage());
		}
	}

	@Override
	public Result addConfig(Long deployid, CommandType commandType, Long taskId) {
		Map<String, Object> params = new HashMap<String, Object>();
		Long middlewareId = null;
		String configName = null;
		Long instanceId = null;
		switch (commandType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			CommonCheckpoint commonCheckpoint = commonCheckpointMapper.selectById(selectTask.getCheckpointId());
			params.putAll(CommandType.proTaskConfig(selectTask, commonCheckpoint));// 默认配置
			configName = commandType.formateConfigName(selectTask.getName());
			middlewareId = selectTask.getMiddlewareId();
			instanceId = selectTask.getInstanceId();
			break;
		default:
			break;
		}
		CommonMiddleware middleware = commonMiddlewareMapper.selectById(middlewareId);
		MiddlewareType middlewareType = MiddlewareType.valueOf(middleware.getMiddlewareType());
		// 配置插件
		Map<String, Object> pluginConfig = middlewareType.proPluginConfig(commandType, middleware.getVersion());
		params.putAll(pluginConfig);
		// 配置目标中间件
		Map<String, Object> proConfig = middlewareType.proConfig(middleware);
		params.putAll(proConfig);
		// 配置监听实例,如consumer可能就没有这个实例
		if (instanceId != null) {
			CommonInstance commonInstance = commonInstanceMapper.selectById(instanceId);
			params.putAll(configInstall(commonInstance));
		}

		String propStr = DeployType.formateConfig(DeployType.k8s, commandType, params);
		k8sService.deployConfigmap(deployid, configName, propStr);
		return Result.getSuc();
	}

	@Override
	public Result deleteConfig(Long deployid, CommandType commandType, Long taskId) {
		String configName = null;
		switch (commandType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			configName = commandType.formateConfigName(selectTask.getName());
			break;
		default:
			break;
		}
		k8sService.deleteConfigmap(deployid, configName);
		return Result.getSuc();
	}

	@Override
	public Result start(Long deployid, CommandType taskType, Long taskId, boolean isDebug) {
		if (!checkExit(deployid, taskType, taskId).isSuc()) {
			addConfig(deployid, taskType, taskId);
		}
		String configName = null;
		Map<String, Object> params = new HashMap<String, Object>();
		switch (taskType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			configName = taskType.formateTaskName(selectTask.getName());
			params.put(ConfigItem.task_name, configName);
			CommonVersion commonVersion = commonVersionMapper.selectById(selectTask.getVersionId());
			params.put(ConfigItem.task_version, commonVersion.getMainVersion());
			params.put(ConfigItem.task_data_version, commonVersion.getDataVersion());
			params.put(ConfigItem.task_image, commonVersion.getImage());
			params.put(ConfigItem.task_debug, isDebug);
			params.put(ConfigItem.configmap_name, taskType.formateConfigName(selectTask.getName()));
			// 处理中间件的hosts
			CommonMiddleware middleware = commonMiddlewareMapper.selectById(selectTask.getMiddlewareId());
			List<Host> jsonToHosts = Host.jsonToHosts(middleware.getHostsconfig());
			params.put(ConfigItem.task_hosts, jsonToHosts);
			break;
		default:
			break;
		}
		V1Deployment deployTask = k8sService.deployTask(deployid, params);
		if (deployTask != null) {
			return Result.getSuc();
		} else {
			return Result.getError("布署失败");
		}
	}

	@Override
	public Result stop(Long deployid, CommandType taskType, Long taskId) {
		String configName = null;
		switch (taskType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			configName = taskType.formateTaskName(selectTask.getName());
			break;
		default:
			break;
		}
		V1Status stopTask = k8sService.stopTask(deployid, configName);
		if ("Success".equals(stopTask.getStatus())) {
			if (checkExit(deployid, taskType, taskId).isSuc()) {// 删除配置信息
				deleteConfig(deployid, taskType, taskId);
			}
			return Result.getSuc();
		} else {
			return Result.getError(stopTask.getReason());
		}
	}

	@Override
	public String queryStatus(Long deployid, CommandType taskType, Long taskId) {
		String configName = null;
		switch (taskType) {
		case task:
			CommonTask selectTask = commonTaskMapper.selectById(taskId);
			configName = taskType.formateTaskName(selectTask.getName());
			break;
		default:
			break;
		}
		try {
			V1Pod queryPod = k8sService.selectPod(deployid, configName);
			return DeployType.k8s.getStatus(queryPod.getStatus().getPhase());
			// 结果不太准确
			// V1Deployment selectDeployment = k8sService.selectDeployment(deployid,
			// configName);
			// Integer availableReplicas =
			// selectDeployment.getStatus().getAvailableReplicas();
			// String statusstr=availableReplicas==1?"Running":"Stoping";
			// return DeployType.k8s.getStatus(statusstr);
		} catch (Exception e) {
			return DeployType.k8s.getStatus(null);
		}
	}

}
