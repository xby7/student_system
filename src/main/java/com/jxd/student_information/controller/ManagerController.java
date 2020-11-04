package com.jxd.student_information.controller;

import com.jxd.student_information.model.Dept;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IDeptService;
import com.jxd.student_information.service.IManagerService;
import com.jxd.student_information.service.IUserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Controller
public class ManagerController {

    @Autowired
    IManagerService managerService;
    @Autowired
    IDeptService deptService;
    @Autowired
    IUserloginService userloginService;

    @RequestMapping("/getAllManager")
    @ResponseBody
    public List<Map<String, Object>> getAllManager(String managerName) {
        return managerService.getAllManagerWithDept_name(managerName);
    }

    @RequestMapping("/getAllManagerByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllManagerByPage(int pageSize, int currentPage, String managerName) {
        return managerService.getAllManagerWithDept_nameByPage(pageSize, currentPage, managerName);
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(String managerName, String deptName) {
        boolean result01 = managerService.addManager(managerName, deptName);
        String role = "2"; //部门主管的权限等级
        String password = "123456"; //默认密码
        boolean result02 = userloginService.addUser(role, password);
        if (result01 && result02 == true) {
            return "添加成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/deleteManager")
    @ResponseBody
    public String deleteManagerById(int managerId) {
        boolean result = managerService.removeById(managerId);
        if (result == true) {
            return "删除成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/getManagerById")
    @ResponseBody
    public Map<String, Object> getManagerById(int managerId) {
        Manager manager = managerService.getById(managerId);
        Dept dept = deptService.getById(manager.getDeptNo());
        Map<String, Object> map = new HashMap<>();
        map.put("managerId", manager.getManagerId());
        map.put("managerName", manager.getManagerName());
        map.put("deptName", dept.getDeptName());
        return map;
    }

    @RequestMapping("/updateManagerById")
    @ResponseBody
    public String updateManagerById(int managerId, String managerName, String deptName) {
        boolean result = managerService.updateManagerById(managerId, managerName, deptName);
        if (result == true) {
            return "修改成功";
        } else {
            return "服务器响应失败";
        }
    }
}
