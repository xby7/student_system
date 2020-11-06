package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IDeptMapper;
import com.jxd.student_information.model.Dept;
import com.jxd.student_information.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class DeptServiceImpl extends ServiceImpl<IDeptMapper, Dept> implements IDeptService {

    @Autowired
    IDeptMapper deptMapper;

    @Override
    public boolean addDept(String deptName) {
        return deptMapper.insertDept(deptName);
    }

    @Override
    public List<Dept> getAllDept(String deptName) {
        return deptMapper.selectAllDept(deptName);
    }

    @Override
    public List<Dept> getAllDeptByPage(int pageSize, int currentPage, String deptName) {
        int pageStart = (currentPage - 1) * pageSize;
        return deptMapper.selectAllDeptByPage(pageStart, pageSize, deptName);
    }

    @Override
    public boolean updateDeptById(int deptNo, String deptName) {
        return deptMapper.updateDeptById(deptNo, deptName);
    }
    //lk
    @Override
    public Integer getAllDeptNo(String deptName) {
        return deptMapper.getAllDeptNo(deptName);
    }


}
