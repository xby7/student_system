package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ICourseMapper extends BaseMapper<Course> {

    /**
     * 获取课程名
     * @return
     * @Author cbb
     */
    List<Map<String, Object>> selectAllCourseName();

}
