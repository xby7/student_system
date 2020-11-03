package com.jxd.student_information.controller;

import com.jxd.student_information.model.Teacher;
import com.jxd.student_information.service.ITeacherService;
import org.apache.ibatis.annotations.Param;
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
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/getAllStuWithTeacher")
    @ResponseBody
    public List<Map<String, Object>> getAll(@Param("student_name") String student_name,
                                            @Param("teacher_id") String teacher_id,
                                            @Param("curPage") String curPage,
                                            @Param("pageSize") String pageSize) {
        if (teacher_id == "" || teacher_id == null) {
            teacher_id = "0";
        }
        //List<Map<String,Object>> list =teacherService.getAllStuWithTeacher(student_name,Integer.parseInt(teacher_id));
        List<Map<String, Object>> list_page = teacherService.getAllStuWithTeacherByPage(student_name,
                Integer.parseInt(teacher_id),
                Integer.parseInt(curPage),
                Integer.parseInt(pageSize));

        return list_page;
    }

    @RequestMapping("/getAllTeacher")
    @ResponseBody
    public List<Teacher> getAllTeacher(String teacherName) {
        return teacherService.getAllTeacher(teacherName);
    }

    @RequestMapping("/getAllTeacherByPage")
    @ResponseBody
    public List<Teacher> getAllTeacherByPage(int pageSize, int currentPage, String teacherName) {
        return teacherService.getAllTeacherByPage(pageSize, currentPage, teacherName);
    }

    @RequestMapping("/addTeacher")
    @ResponseBody
    public String addTeacher(String teacherName) {
        boolean result = teacherService.addTeacher(teacherName);
        if (result == true) {
            return "添加成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteTeacher(int teacherId) {
        boolean result = teacherService.removeById(teacherId);
        if (result == true) {
            return "删除成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/getTeacherById")
    @ResponseBody
    public Teacher getTeacherById(int teacherId) {
        return teacherService.getById(teacherId);
    }

    @RequestMapping("/updateTeacherById")
    @ResponseBody
    public String updateTeacherById(int teacherId, String teacherName) {
        boolean result = teacherService.updateTeacherById(teacherId, teacherName);
        if (result == true) {
            return "更新成功";
        } else {
            return "服务器响应失败";
        }
    }


}
