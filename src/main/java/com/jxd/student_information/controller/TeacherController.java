package com.jxd.student_information.controller;

import com.jxd.student_information.model.Teacher;
import com.jxd.student_information.service.ICourseService;
import com.jxd.student_information.service.ITeacherService;
import com.jxd.student_information.service.IUserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IUserloginService userloginService;


    @RequestMapping("/getAllStuWithTeacher")
    @ResponseBody
    public Map<String, Object> getAll(String student_name, String teacher_id, String curPage, String pageSize) {
        if (teacher_id == "" || teacher_id == null) {
            teacher_id = "0";
        }

        curPage = curPage == null ? "1" : curPage;
        pageSize = pageSize == null ? "5" : pageSize;

        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> totals = teacherService.getAllStuTotalsWithTeacher(student_name, Integer.parseInt(teacher_id));

        List<Map<String, Object>> students = teacherService.getAllStuWithTeacherByPage(student_name,
                Integer.parseInt(teacher_id),
                Integer.parseInt(curPage),
                Integer.parseInt(pageSize));

        List<Map<String, Object>> tableColumnList = courseService.getAllCourseName();

        map.put("students", students);
        map.put("total", totals);
        map.put("tableNameList", tableColumnList);

        return map;
    }

    //xby
    @RequestMapping("/getAllTeacher")
    @ResponseBody
    public List<Teacher> getAllTeacher(String teacherName) {
        return teacherService.getAllTeacher(teacherName);
    }

    //xby
    @RequestMapping("/getAllTeacherByPage")
    @ResponseBody
    public List<Teacher> getAllTeacherByPage(int pageSize, int currentPage, String teacherName) {
        return teacherService.getAllTeacherByPage(pageSize, currentPage, teacherName);
    }

    //xby

    /**
     * 添加教师信息时，将该教师 id 作为user_name，教师名称作为用户名，默认密码
     * ，以及教师权限等级"1" 插入到用户登陆表中
     * 该教师 id 通过 sql 语句查询
     */
    @RequestMapping("/addTeacher")
    @ResponseBody
    public String addTeacher(String teacherName) {
        String role = "1"; //教师的权限等级
        String password = "123456"; //默认密码
        boolean result = teacherService.addTeacher(role, password,teacherName);
        if (result == true) {
            return "添加成功";
        } else {
            return "添加失败，请稍后再试";
        }
    }

    //xby

    /**
     * 删除教师信息时将用户表中的登录信息
     * @param teacherId
     * @return
     */
    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteTeacher(int teacherId) {
        boolean result = teacherService.removeById(teacherId);
        if (result == true) {
            return "删除成功";
        } else {
            return "删除失败，请稍后再试";
        }
    }

    //xby
    @RequestMapping("/getTeacherById")
    @ResponseBody
    public Teacher getTeacherById(int teacherId) {
        return teacherService.getById(teacherId);
    }

    //xby
    @RequestMapping("/updateTeacherById")
    @ResponseBody
    public String updateTeacherById(int teacherId, String teacherName) {
        boolean result = teacherService.updateTeacherById(teacherId, teacherName);
        if (result == true) {
            return "更新成功";
        } else {
            return "更新失败，请稍后再试";
        }
    }

    //xby

    /**
     * 用于渲染教师选择下拉框
     * @return 教师信息列表 "id name"形式
     */
    @RequestMapping("/getAllTeacher_name")
    @ResponseBody
    public List<String> getAllTeacher_name() {
        List<String> teacher_names = new ArrayList<>();
        List<Teacher> teachers = teacherService.list();

        for (Teacher teacher : teachers) {
            teacher_names.add(teacher.getTeacherId() + " " + teacher.getTeacherName());
        }
        return teacher_names;
    }
}
