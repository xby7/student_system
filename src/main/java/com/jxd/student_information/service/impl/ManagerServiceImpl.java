package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IManagerMapper;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<IManagerMapper, Manager> implements IManagerService {

    @Autowired
    IManagerMapper managerMapper;

    @Override
    public List<Map<String, Object>> getAllManagerWithDept_name(String managerName) {
        return managerMapper.selectAllManagerWithDept_name(managerName);
    }

    @Override
    public List<Map<String, Object>> getAllManagerWithDept_nameByPage(int pageSize, int currentPage, String managerName) {
        int pageStart = (currentPage - 1) * pageSize;
        return managerMapper.selectAllManagerWithDept_nameByPage(pageStart, pageSize, managerName);
    }

    @Override
    public boolean addManager(String managerName, String deptName) {
        return managerMapper.insertManager(managerName, deptName);
    }

    @Override
    public boolean updateManagerById(int managerId, String managerName, String deptName) {
        return managerMapper.updateManagerById(managerId,managerName,deptName);
    }

}
