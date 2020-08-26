package net.wicp.tams.app.duckula.controller.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import net.wicp.tams.app.duckula.controller.bean.models.CommonTask;
import java.util.List;
import net.wicp.tams.app.duckula.controller.bean.models.CommonTaskExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommonTaskMapper extends BaseMapper<CommonTask> {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	long countByExample(CommonTaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	int deleteByExample(CommonTaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	@Delete({ "delete from common_task", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	@Insert({ "insert into common_task (id, name, ", "version, rule, deploy_id, ", "user_id)",
			"values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=VARCHAR}, #{rule,jdbcType=VARCHAR}, #{deployId,jdbcType=BIGINT}, ",
			"#{userId,jdbcType=INTEGER})" })
	int insert(CommonTask record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	int insertSelective(CommonTask record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	List<CommonTask> selectByExample(CommonTaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	@Select({ "select", "id, name, version, rule, deploy_id, user_id", "from common_task",
			"where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("net.wicp.tams.app.duckula.controller.dao.CommonTaskMapper.BaseResultMap")
	CommonTask selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") CommonTask record, @Param("example") CommonTaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") CommonTask record, @Param("example") CommonTaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(CommonTask record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table common_task
	 * @mbg.generated
	 */
	@Update({ "update common_task", "set name = #{name,jdbcType=VARCHAR},", "version = #{version,jdbcType=VARCHAR},",
			"rule = #{rule,jdbcType=VARCHAR},", "deploy_id = #{deployId,jdbcType=BIGINT},",
			"user_id = #{userId,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(CommonTask record);

}
