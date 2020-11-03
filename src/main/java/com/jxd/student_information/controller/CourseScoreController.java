package com.jxd.student_information.controller;

import com.jxd.student_information.model.CourseScore;
import com.jxd.student_information.service.ICourseScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
public class CourseScoreController {

    @Autowired
    private ICourseScoreService courseScoreService;

    @RequestMapping("/updateStuScoreWithTeacher")
    @ResponseBody
    public String updateStuScoreWithTeacher(List<CourseScore> scoreList) {

        boolean flag = courseScoreService.updateStuScoreWithTeacher(scoreList);
        if (flag) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/getScoreByStudentId")
    @ResponseBody
    public Map<String, Object> getScoreByStudentId(int studentId){
        List<Map<String, Object>> scoreWithStudent = courseScoreService.getScoreWithStudentId(studentId);
        Map<String, Object> map = new HashMap<>();
        map.put("scoreWithStudent",scoreWithStudent);
        return map;
    }
}
