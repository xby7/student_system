package com.jxd.student_information.controller;

import com.jxd.student_information.model.Dept;
import com.jxd.student_information.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    IDeptService deptService;

    //xby

    /**
     * @return 所有部门名称，用于渲染部门选择下拉框
     */
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

    //xby
    @RequestMapping("/getAllDept")
    @ResponseBody
    public List<Dept> getAllDept(String deptName) {
        return deptService.getAllDept(deptName);
    }

    //xby

    /**
     * @param pageSize    页面数据条数
     * @param currentPage 当前页面号，从1开始
     * @param deptName    部门名称，用于前台查询功能（模糊查询）
     */
    @RequestMapping("/getAllDeptByPage")
    @ResponseBody
    public List<Dept> getAllDeptByPage(int pageSize, int currentPage, String deptName) {
        return deptService.getAllDeptByPage(pageSize, currentPage, deptName);
    }

    //xby
    @RequestMapping("/addDept")
    @ResponseBody
    public String addDept(String deptName) {
        boolean result = deptService.addDept(deptName);
        if (result == true) {
            return "添加成功";
        } else {
            return "添加失败，请稍后再试";
        }
    }

    //xby
    @RequestMapping("/deleteDept")
    @ResponseBody
    public String deleteDept(int deptNo) {
        boolean result = deptService.removeById(deptNo);
        if (result == true) {
            return "删除成功";
        } else {
            return "删除失败，请稍后再试";
        }
    }

    //xby
    @RequestMapping("/getDeptById")
    @ResponseBody
    public Dept getDeptById(int deptNo) {
        return deptService.getById(deptNo);
    }

    //xby
    @RequestMapping("/updateDeptById")
    @ResponseBody
    public String updateDeptById(int deptNo, String deptName) {
        boolean result = deptService.updateDeptById(deptNo, deptName);
        if (result == true) {
            return "更新成功";
        } else {
            return "更新失败，请稍后再试";
        }
    }
}

