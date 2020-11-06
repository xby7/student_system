package com.jxd.student_information.service;

import com.jxd.student_information.model.CourseScore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface ICourseScoreService extends IService<CourseScore> {
    //批量更新单个学生的所有品质分数===教师(cbb)
    boolean updateStuScoreWithTeacher(List<CourseScore> list);

    //根据学生id获取学生成绩信息===教师(cbb)
    List<Map<String, Object>> getScoreWithStudentId(int studentId);
}
