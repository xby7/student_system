package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IStudentMapper;
import com.jxd.student_information.model.Student;
import com.jxd.student_information.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class StudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {

}
