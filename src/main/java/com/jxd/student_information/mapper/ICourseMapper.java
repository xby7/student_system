package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface ICourseMapper extends BaseMapper<Course> {
    //获取课程名
    List<Map<String, Object>> selectAllCourseName();

}
