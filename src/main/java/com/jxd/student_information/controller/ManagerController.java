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
 *  前端控制器
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
    public List<Map<String, Object>> getAllManager(String manager_name) {
        return managerService.getAllManagerWithDept_name(manager_name);
    }

    @RequestMapping("/getAllManagerByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllManagerBypage(int pageSize, int currentPage, String manager_name) {
        return managerService.getAllManagerWithDept_nameByPage(pageSize, currentPage, manager_name);
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(String managerName,String deptName){
        boolean result =  managerService.addManager(managerName,deptName);
        if (result == true){
            return "添加成功";
        }else {
            return "服务器相应失败失败";
        }
    }

}
