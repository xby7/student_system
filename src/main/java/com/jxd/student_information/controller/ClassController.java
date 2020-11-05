package com.jxd.student_information.controller;

import com.jxd.student_information.model.Class;
import com.jxd.student_information.model.Teacher;
import com.jxd.student_information.service.IClassService;
import com.jxd.student_information.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassController {

    @Autowired
    IClassService classService;
    @Autowired
    ITeacherService teacherService;

    // xby

    /**
     * @return 包含教师姓名的班级信息
     */
    @RequestMapping("/getAllClass")
    @ResponseBody
    public List<Map<String, Object>> getAllClass() {
        return classService.getAllClassWithTeacher_name();
    }

    // xby

    /**
     * @param pageSize    页面数据条数
     * @param currentPage 当前页面号，从1开始
     */
    @RequestMapping("/getAllClassByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllClassByPage(int pageSize, int currentPage) {
        return classService.getAllClassWithTeacher_nameByPage(pageSize, currentPage);
    }

    // xby

    /**
     * @param teacherId 是 "1 张三" 这种形式
     */
    @RequestMapping("/addClass")
    @ResponseBody
    public String addClass(String teacherId) {
        int teacherId_int = Integer.parseInt(teacherId.split(" ")[0]);
        boolean result = classService.addClass(teacherId_int);
        if (result == true) {
            return "添加成功";
        } else {
            return "添加失败，请稍后再试";
        }
    }

    // xby
    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteClassByNo(int classNo) {
        boolean result = classService.removeById(classNo);
        if (result == true) {
            return "删除成功";
        } else {
            return "删除失败，请稍后再试";
        }
    }

    // xby

    /**
     * @return 返回的是一个 map 包含班期和 教师信息("1 张三"的形式)
     */
    @RequestMapping("/getClassById")
    @ResponseBody
    public Map<String, Object> getClassById(int classNo) {
        Class aClass = classService.getById(classNo);
        Teacher teacher = teacherService.getById(aClass.getTeacherId());
        Map<String, Object> map = new HashMap<>();
        map.put("classNo", aClass.getClassNo());
        map.put("teacherId", teacher.getTeacherId() + " " + teacher.getTeacherName());
        return map;
    }

    // xby

    /**
     * @param teacherId 是 "1 张三" 这种形式
     */
    @RequestMapping("/updateClassById")
    @ResponseBody
    public String updateClassById(int classNo, String teacherId) {
        int teacherId_int = Integer.parseInt(teacherId.split(" ")[0]);
        boolean result = classService.updateClassById(classNo, teacherId_int);
        if (result == true) {
            return "修改成功";
        } else {
            return "修改失败，请稍后再试";
        }
    }

}
