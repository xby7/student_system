package com.jxd.student_information.service;

import com.jxd.student_information.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IStudentService extends IService<Student> {
    List<Map<String,Object>> getAllStudent(String student_name, int class_no);

    List<Map<String,Object>> getAllStudentByPage(String student_name, int class_no,int curPage,int pageSize);
}
