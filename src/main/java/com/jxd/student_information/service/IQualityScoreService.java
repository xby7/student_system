package com.jxd.student_information.service;

import com.jxd.student_information.model.QualityScore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IQualityScoreService extends IService<QualityScore> {

    //获取学生的品质分数信息===经理(cbb)
    List<Map<String,Object>> getScoreWithManagerByStudentId(int studentId,int periodOn);

    //批量更新单个学生的所有品质分数===经理(cbb)
    boolean updateStuScoreWithManager(List<QualityScore> qualityScores);

}
