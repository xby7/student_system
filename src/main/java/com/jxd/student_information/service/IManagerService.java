package com.jxd.student_information.service;

import com.jxd.student_information.model.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IManagerService extends IService<Manager> {

    List<Map<String, Object>> getAllManagerWithDept_name(String managerName);

    List<Map<String, Object>> getAllManagerWithDept_nameByPage(int pageSize, int currentPage, String managerName);

    boolean addManager(String role, String password, String managerName, String deptName);

    boolean updateManagerById(int managerId, String managerName, String deptName);
}
