package net.wicp.tams.app.duckula.controller.dao;

import java.util.List;
import net.wicp.tams.app.duckula.controller.bean.models.CommonConsumer;
import net.wicp.tams.app.duckula.controller.bean.models.CommonConsumerExample;
import net.wicp.tams.app.duckula.controller.bean.models.CommonTask;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CommonConsumerMapper extends BaseMapper<CommonConsumer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    long countByExample(CommonConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    int deleteByExample(CommonConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    @Delete({
        "delete from common_consumer",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    @Insert({
        "insert into common_consumer (id, name, ",
        "topic, rule, version_id, ",
        "deploy_id, user_id, ",
        "middleware_kafka_id, middleware_id, ",
        "instance_id, group_id, ",
        "attr_config)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{topic,jdbcType=VARCHAR}, #{rule,jdbcType=VARCHAR}, #{versionId,jdbcType=BIGINT}, ",
        "#{deployId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{middlewareKafkaId,jdbcType=BIGINT}, #{middlewareId,jdbcType=BIGINT}, ",
        "#{instanceId,jdbcType=BIGINT}, #{groupId,jdbcType=INTEGER}, ",
        "#{attrConfig,jdbcType=VARCHAR})"
    })
    int insert(CommonConsumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    int insertSelective(CommonConsumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    List<CommonConsumer> selectByExample(CommonConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, name, topic, rule, version_id, deploy_id, user_id, middleware_kafka_id, ",
        "middleware_id, instance_id, group_id, attr_config",
        "from common_consumer",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("net.wicp.tams.app.duckula.controller.dao.CommonConsumerMapper.BaseResultMap")
    CommonConsumer selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CommonConsumer record, @Param("example") CommonConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CommonConsumer record, @Param("example") CommonConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CommonConsumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table common_consumer
     *
     * @mbg.generated
     */
    @Update({
        "update common_consumer",
        "set name = #{name,jdbcType=VARCHAR},",
          "topic = #{topic,jdbcType=VARCHAR},",
          "rule = #{rule,jdbcType=VARCHAR},",
          "version_id = #{versionId,jdbcType=BIGINT},",
          "deploy_id = #{deployId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "middleware_kafka_id = #{middlewareKafkaId,jdbcType=BIGINT},",
          "middleware_id = #{middlewareId,jdbcType=BIGINT},",
          "instance_id = #{instanceId,jdbcType=BIGINT},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "attr_config = #{attrConfig,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommonConsumer record);
}