package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.ICourseMapper;
import com.jxd.student_information.model.Course;
import com.jxd.student_information.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class CourseServiceImpl extends ServiceImpl<ICourseMapper, Course> implements ICourseService {

    @Autowired
    private ICourseMapper courseMapper;

    @Override
    public List<Map<String, Object>> getAllCourseName() {
        return courseMapper.selectAllCourseName();
    }
}
