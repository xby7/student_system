package com.jxd.student_information.controller;

import com.jxd.student_information.model.EvaluationOfSchool;
import com.jxd.student_information.service.IEvaluationOfSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class EvaluationOfSchoolController {
    @Autowired
    private IEvaluationOfSchoolService evaluationOfSchoolService;

    //获取学生的评价信息
    @RequestMapping("/getEvaluationByStudentId")
    @ResponseBody
    public EvaluationOfSchool getEvaluationByStudentId(int studentId){
        return evaluationOfSchoolService.getEvaluationWithStudentId(studentId);
    }

    //教师评价学生
    @RequestMapping("/evaluatingStudentWithTeacher")
    @ResponseBody
    public String evaluatingStudentWithTeacher(String teacherName,int studentId,int overallScore,String evaluationFormSchool){

        EvaluationOfSchool evaluationOfSchool = new EvaluationOfSchool();
        evaluationOfSchool.setTeacherName(teacherName);
        evaluationOfSchool.setStudentId(studentId);
        evaluationOfSchool.setOverallScore(overallScore);
        evaluationOfSchool.setEvaluationFormSchool(evaluationFormSchool);

        boolean flag = evaluationOfSchoolService.evaluatingStudent(evaluationOfSchool);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

}
