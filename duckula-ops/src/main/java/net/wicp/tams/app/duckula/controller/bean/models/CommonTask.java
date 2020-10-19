package net.wicp.tams.app.duckula.controller.bean.models;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table common_task
 */
public class CommonTask {

	/**
	 * Database Column Remarks: id This field was generated by MyBatis Generator. This field corresponds to the database column common_task.id
	 * @mbg.generated
	 */
	private Long id;
	/**
	 * Database Column Remarks: 监听名称 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.name
	 * @mbg.generated
	 */
	private String name;
	/**
	 * Database Column Remarks: duckula监听的版本 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.version
	 * @mbg.generated
	 */
	private String version;
	/**
	 * Database Column Remarks: 缓冲类型，disruptor,threadpoolmuli This field was generated by MyBatis Generator. This field corresponds to the database column common_task.buffer_type
	 * @mbg.generated
	 */
	private String bufferType;
	/**
	 * Database Column Remarks: 发送线程数，默认为3 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.sendNum
	 * @mbg.generated
	 */
	private Integer sendnum;
	/**
	 * Database Column Remarks: 规则 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.rule
	 * @mbg.generated
	 */
	private String rule;
	/**
	 * Database Column Remarks: 部署ID配置 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.deploy_id
	 * @mbg.generated
	 */
	private Long deployId;
	/**
	 * Database Column Remarks: 用户id This field was generated by MyBatis Generator. This field corresponds to the database column common_task.user_id
	 * @mbg.generated
	 */
	private Long userId;
	/**
	 * Database Column Remarks: 目的中间件配置 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.middleware_id
	 * @mbg.generated
	 */
	private Long middlewareId;
	/**
	 * Database Column Remarks: 需要监听的实例配置 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.instance_id
	 * @mbg.generated
	 */
	private Long instanceId;
	/**
	 * Database Column Remarks: 组id，用于分布式锁，checkpoint mysql启作用 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.group_id
	 * @mbg.generated
	 */
	private Integer groupId;
	/**
	 * Database Column Remarks: 默认为内存模式 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.checkpoint
	 * @mbg.generated
	 */
	private String checkpoint;
	/**
	 * Database Column Remarks: 连接mysql的客户端，最初由id生成 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.client_id
	 * @mbg.generated
	 */
	private Integer clientId;
	/**
	 * Database Column Remarks: cur表示从当前最新位点启动，last表示从记录的最后位点启动，pos表示从上面设置的gtids启动 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.ha_type
	 * @mbg.generated
	 */
	private String haType;
	/**
	 * Database Column Remarks: 开始的gtid值。 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.gtids
	 * @mbg.generated
	 */
	private String gtids;
	/**
	 * Database Column Remarks: 附加的配置，如自动创建ES索引 This field was generated by MyBatis Generator. This field corresponds to the database column common_task.attr_config
	 * @mbg.generated
	 */
	private String attrConfig;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	public CommonTask(Long id, String name, String version, String bufferType, Integer sendnum, String rule,
			Long deployId, Long userId, Long middlewareId, Long instanceId, Integer groupId, String checkpoint,
			Integer clientId, String haType, String gtids, String attrConfig) {
		this.id = id;
		this.name = name;
		this.version = version;
		this.bufferType = bufferType;
		this.sendnum = sendnum;
		this.rule = rule;
		this.deployId = deployId;
		this.userId = userId;
		this.middlewareId = middlewareId;
		this.instanceId = instanceId;
		this.groupId = groupId;
		this.checkpoint = checkpoint;
		this.clientId = clientId;
		this.haType = haType;
		this.gtids = gtids;
		this.attrConfig = attrConfig;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	public CommonTask() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.id
	 * @return  the value of common_task.id
	 * @mbg.generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.id
	 * @param id  the value for common_task.id
	 * @mbg.generated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.name
	 * @return  the value of common_task.name
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.name
	 * @param name  the value for common_task.name
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.version
	 * @return  the value of common_task.version
	 * @mbg.generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.version
	 * @param version  the value for common_task.version
	 * @mbg.generated
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.buffer_type
	 * @return  the value of common_task.buffer_type
	 * @mbg.generated
	 */
	public String getBufferType() {
		return bufferType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.buffer_type
	 * @param bufferType  the value for common_task.buffer_type
	 * @mbg.generated
	 */
	public void setBufferType(String bufferType) {
		this.bufferType = bufferType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.sendNum
	 * @return  the value of common_task.sendNum
	 * @mbg.generated
	 */
	public Integer getSendnum() {
		return sendnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.sendNum
	 * @param sendnum  the value for common_task.sendNum
	 * @mbg.generated
	 */
	public void setSendnum(Integer sendnum) {
		this.sendnum = sendnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.rule
	 * @return  the value of common_task.rule
	 * @mbg.generated
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.rule
	 * @param rule  the value for common_task.rule
	 * @mbg.generated
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.deploy_id
	 * @return  the value of common_task.deploy_id
	 * @mbg.generated
	 */
	public Long getDeployId() {
		return deployId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.deploy_id
	 * @param deployId  the value for common_task.deploy_id
	 * @mbg.generated
	 */
	public void setDeployId(Long deployId) {
		this.deployId = deployId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.user_id
	 * @return  the value of common_task.user_id
	 * @mbg.generated
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.user_id
	 * @param userId  the value for common_task.user_id
	 * @mbg.generated
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.middleware_id
	 * @return  the value of common_task.middleware_id
	 * @mbg.generated
	 */
	public Long getMiddlewareId() {
		return middlewareId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.middleware_id
	 * @param middlewareId  the value for common_task.middleware_id
	 * @mbg.generated
	 */
	public void setMiddlewareId(Long middlewareId) {
		this.middlewareId = middlewareId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.instance_id
	 * @return  the value of common_task.instance_id
	 * @mbg.generated
	 */
	public Long getInstanceId() {
		return instanceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.instance_id
	 * @param instanceId  the value for common_task.instance_id
	 * @mbg.generated
	 */
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.group_id
	 * @return  the value of common_task.group_id
	 * @mbg.generated
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.group_id
	 * @param groupId  the value for common_task.group_id
	 * @mbg.generated
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.checkpoint
	 * @return  the value of common_task.checkpoint
	 * @mbg.generated
	 */
	public String getCheckpoint() {
		return checkpoint;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.checkpoint
	 * @param checkpoint  the value for common_task.checkpoint
	 * @mbg.generated
	 */
	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.client_id
	 * @return  the value of common_task.client_id
	 * @mbg.generated
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.client_id
	 * @param clientId  the value for common_task.client_id
	 * @mbg.generated
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.ha_type
	 * @return  the value of common_task.ha_type
	 * @mbg.generated
	 */
	public String getHaType() {
		return haType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.ha_type
	 * @param haType  the value for common_task.ha_type
	 * @mbg.generated
	 */
	public void setHaType(String haType) {
		this.haType = haType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.gtids
	 * @return  the value of common_task.gtids
	 * @mbg.generated
	 */
	public String getGtids() {
		return gtids;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.gtids
	 * @param gtids  the value for common_task.gtids
	 * @mbg.generated
	 */
	public void setGtids(String gtids) {
		this.gtids = gtids;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column common_task.attr_config
	 * @return  the value of common_task.attr_config
	 * @mbg.generated
	 */
	public String getAttrConfig() {
		return attrConfig;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column common_task.attr_config
	 * @param attrConfig  the value for common_task.attr_config
	 * @mbg.generated
	 */
	public void setAttrConfig(String attrConfig) {
		this.attrConfig = attrConfig;
	}
}