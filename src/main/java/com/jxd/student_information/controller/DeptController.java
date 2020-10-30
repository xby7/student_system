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
}

