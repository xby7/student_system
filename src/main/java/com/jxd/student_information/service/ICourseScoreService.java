package com.jxd.student_information.service;

import com.jxd.student_information.model.CourseScore;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface ICourseScoreService extends IService<CourseScore> {
    boolean updateStuScoreWithTeacher(List<CourseScore> list);

    //根据学生id获取学生成绩信息
    List<Map<String, Object>> getScoreWithStudentId(int studentId);
}
