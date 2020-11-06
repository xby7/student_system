package com.jxd.student_information.controller;

import com.jxd.student_information.model.Class;
import com.jxd.student_information.model.Teacher;
import com.jxd.student_information.service.IClassService;
import com.jxd.student_information.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
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
public class ClassController {

    @Autowired
    IClassService classService;
    @Autowired
    ITeacherService teacherService;

    @RequestMapping("/getAllClass")
    @ResponseBody
    public List<Map<String, Object>> getAllClass() {
        return classService.getAllClassWithTeacher_name();
    }

    @RequestMapping("/getAllClassByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllClassByPage(int pageSize, int currentPage) {
        return classService.getAllClassWithTeacher_nameByPage(pageSize, currentPage);
    }

    @RequestMapping("/addClass")
    @ResponseBody
    public String addClass(String teacherId) {
        int teacherId_int = Integer.parseInt(teacherId.split(" ")[0]);
        boolean result = classService.addClass(teacherId_int);
        if (result == true) {
            return "添加成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteClassByNo(int classNo) {
        boolean result = classService.removeById(classNo);
        if (result == true) {
            return "删除成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/getClassByNo")
    @ResponseBody
    public Map<String, Object> getClassByNo(int classNo) {
        Class aClass = classService.getById(classNo);
        Teacher teacher = teacherService.getById(aClass.getTeacherId());
        Map<String, Object> map = new HashMap<>();
        map.put("classNo", aClass.getClassNo());
        map.put("teacherId", teacher.getTeacherId()+" "+teacher.getTeacherName());
        return map;
    }

    @RequestMapping("/updateClassByNo")
    @ResponseBody
    public String updateClassByNo(int classNo, String teacherId) {
        int teacherId_int = Integer.parseInt(teacherId.split(" ")[0]);
        boolean result = classService.updateClassByNo(classNo,teacherId_int);
        if (result == true) {
            return "修改成功";
        } else {
            return "服务器响应失败";
        }
    }

    /**
     * @return 所有班级号，用于渲染班级选择下拉框
     */
    @RequestMapping("/getAllClass_no")
    @ResponseBody
    public List<Integer> getAllClass_no() {

        List<Integer> class_nos = new ArrayList<>();
        List<Class> classess= classService.list();

        for (Class classes: classess) {
            class_nos.add(classes.getClassNo());
        }
        return class_nos;
    }
}
