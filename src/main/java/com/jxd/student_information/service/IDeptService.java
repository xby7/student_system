package com.jxd.student_information.service;

import com.jxd.student_information.model.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IDeptService extends IService<Dept> {

    boolean addDept(String deptName);

    List<Dept> getAllDept(String deptName);

    List<Dept> getAllDeptByPage(int pageSize,int currentPage,String deptName);

    boolean updateDeptById(int deptNo, String deptName);

    //lk
    Integer getAllDeptNo(String deptName);
}
