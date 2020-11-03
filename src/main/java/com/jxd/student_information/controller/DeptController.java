package com.jxd.student_information.controller;

import com.jxd.student_information.model.Dept;
import com.jxd.student_information.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Controller
public class DeptController {

    @Autowired
    IDeptService deptService;

    @RequestMapping("/getAllDept_name")
    @ResponseBody
    public List<String> getAllDept_name() {

        List<String> dept_names = new ArrayList<>();
        List<Dept> depts = deptService.list();

        for (Dept dept : depts) {
            dept_names.add(dept.getDeptName());
        }
        return dept_names;
    }

    @RequestMapping("/getAllDept")
    @ResponseBody
    public List<Dept> getAllDept(String deptName){
        return deptService.getAllDept(deptName);
    }

    @RequestMapping("/getAllDeptByPage")
    @ResponseBody
    public List<Dept> getAllDeptByPage(int pageSize,int currentPage,String deptName){
        return deptService.getAllDeptByPage(pageSize,currentPage,deptName);
    }

    @RequestMapping("/addDept")
    @ResponseBody
    public String addDept(String deptName) {
        boolean result = deptService.addDept(deptName);
        if (result == true) {
            return "添加成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/deleteDept")
    @ResponseBody
    public String deleteDept(int deptNo){
        boolean result = deptService.removeById(deptNo);
        if (result == true) {
            return "删除成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/getDeptById")
    @ResponseBody
    public Dept getDeptById(int deptNo){
        return deptService.getById(deptNo);
    }

    @RequestMapping("/updateDeptById")
    @ResponseBody
    public String updateDeptById(int deptNo, String deptName){
        boolean result = deptService.updateDeptById(deptNo,deptName);
        if (result == true) {
            return "更新成功";
        } else {
            return "服务器响应失败";
        }
    }
}

