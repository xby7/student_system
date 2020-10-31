package com.jxd.student_information.controller;

import com.jxd.student_information.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        boolean result = managerService.addManager(managerName, deptName);
        if (result == true) {
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

}
