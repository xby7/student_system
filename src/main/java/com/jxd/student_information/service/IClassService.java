package com.jxd.student_information.service;

import com.jxd.student_information.model.Class;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IClassService extends IService<Class> {

    List<Map<String, Object>> getAllClassWithTeacher_name();

    List<Map<String, Object>> getAllClassWithTeacher_nameByPage(int pageSize, int currentPage);

    boolean addClass(int teacherId);

    boolean updateClassById(int classNo, int teacherId);

}
