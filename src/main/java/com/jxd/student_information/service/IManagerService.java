package com.jxd.student_information.service;

import com.jxd.student_information.model.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IManagerService extends IService<Manager> {

    List<Map<String, Object>> getAllManagerWithDept_name(String manager_name);

    List<Map<String, Object>> getAllManagerWithDept_nameByPage(int pageSize, int currentPage, String manager_name);

    boolean addManager(String managerName, String deptNo);
}
