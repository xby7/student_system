package com.jxd.student_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.student_information.mapper.IStudentMapper;
import com.jxd.student_information.model.Student;
import com.jxd.student_information.service.IStudentService;
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

    @Override
    public boolean addStudents(Student student) {
        return studentMapper.addStudents(student);
    }

    @Override
    public boolean delStudent(Integer studentId) {
        return studentMapper.delStudent(studentId);
    }

    @Override
    public boolean editStudent(Student student) {
        return studentMapper.editStudent(student);
    }

    @Override
    public boolean delSelectStu(List<Integer> stu_id) {
        return studentMapper.delSelectStu(stu_id);
    }



    @Override
    public Map<String, Object> getStudentWithUserById(int studentId) {
        return studentMapper.selectStudentWithUserById(studentId);
    }

}
