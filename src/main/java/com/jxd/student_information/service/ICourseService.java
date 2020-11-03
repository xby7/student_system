package com.jxd.student_information.service;

import com.jxd.student_information.model.Course;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface ICourseService extends IService<Course> {
    //获取全部的课程名
    List<Map<String, Object>> getAllCourseName();
}
