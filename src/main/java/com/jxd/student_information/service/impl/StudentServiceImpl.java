package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IStudentMapper;
import com.jxd.student_information.model.Student;
import com.jxd.student_information.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {
    @Autowired
    private IStudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> getAllStudent(String student_name, int class_no) {
        return studentMapper.getAllStudent(student_name,class_no);
    }

    @Override
    public List<Map<String, Object>> getAllStudentByPage(String student_name, int class_no, int curPage, int pageSize) {
        int pageIndex = (curPage-1)*pageSize;

        return studentMapper.getAllStudentByPage(student_name,class_no,pageIndex,pageSize);
    }
}
