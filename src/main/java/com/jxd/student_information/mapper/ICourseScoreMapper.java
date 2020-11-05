package com.jxd.student_information.mapper;

import com.jxd.student_information.model.CourseScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICourseScoreMapper extends BaseMapper<CourseScore> {
    //老师打分
    boolean updateStuScoreWithTeacher(List<CourseScore> list);

    //根据学生id获取学生成绩信息
    List<Map<String, Object>> selectScoreWithStudentId(@Param("studentId") int studentId);
}
