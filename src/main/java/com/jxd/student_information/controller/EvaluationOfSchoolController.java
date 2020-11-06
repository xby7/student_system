package com.jxd.student_information.controller;

import com.jxd.student_information.model.EvaluationOfSchool;
import com.jxd.student_information.service.IEvaluationOfSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvaluationOfSchoolController {
    @Autowired
    private IEvaluationOfSchoolService evaluationOfSchoolService;

    /**
     * 获取学生的评价信息===教师
     * @param studentId 学生id
     * @return
     * @Author cbb
     */
    @RequestMapping("/getEvaluationByStudentId")
    @ResponseBody
    public EvaluationOfSchool getEvaluationByStudentId(int studentId){
        return evaluationOfSchoolService.getEvaluationWithStudentId(studentId);
    }


    /**
     * 评价学生===教师（
     * @param teacherName   教师姓名
     * @param studentId     学生id
     * @param overallScore  评价分数
     * @param evaluationFormSchool  评语
     * @return
     * @Author cbb
     */
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
