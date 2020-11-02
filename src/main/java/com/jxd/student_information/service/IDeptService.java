package com.jxd.student_information.service;

import com.jxd.student_information.model.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IDeptService extends IService<Dept> {

    boolean addDept(String deptName);

    List<Dept> getAllDeptByPage(int pageSize,int currentPage);

    boolean updateDeptById(int deptNo, String deptName);
}
