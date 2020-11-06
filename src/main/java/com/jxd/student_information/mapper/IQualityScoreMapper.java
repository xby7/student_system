package com.jxd.student_information.mapper;

import com.jxd.student_information.model.QualityScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IQualityScoreMapper extends BaseMapper<QualityScore> {

    /**
     * 获取品质分数信息===经理
     * @param studentId 学生id
     * @param periodNo  时期
     * @return
     * @Author cbb
     */
    List<Map<String, Object>> selectScoreWithManagerByStudentId(@Param("studentId") int studentId,
                                                                @Param("periodNo") int periodNo);

    /**
     * 品质打分===经理
     * @param qualityScores list集合对象
     * @return
     * @Author cbb
     */
    boolean updateStuScoreWithManager(List<QualityScore> qualityScores);

}
