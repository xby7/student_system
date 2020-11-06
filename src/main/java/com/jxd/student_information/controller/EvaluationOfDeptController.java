package com.jxd.student_information.controller;

import com.jxd.student_information.model.EvaluationOfDept;
import com.jxd.student_information.service.IEvaluationOfDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Controller
public class EvaluationOfDeptController {

    @Autowired
    private IEvaluationOfDeptService evaluationOfDeptService;

    /**
     *获取学生的评价信息===经理
     * @param studentId 学生id
     * @param periodNo  工作的时期
     * @return
     * @Author cbb
     */
    @RequestMapping("/getEvaluationWithManagerByStudentId")
    @ResponseBody
    public EvaluationOfDept getEvaluationWithManagerByStudentId(int studentId,int periodNo){
        return evaluationOfDeptService.getEvaluationWithManagerByStudentId(studentId, periodNo);
    }


    /**
     * 评价学生===经理（
     * @param managerName 经理姓名
     * @param studentId   学生id
     * @param periodNo     工作时期
     * @param overallScore  评价分数
     * @param evaluationFormDept    评语
     * @return
     * @Author cbb
     */
    @RequestMapping("/evaluatingStudentWithManager")
    @ResponseBody
    public String evaluatingStudentWithManager(String managerName,int studentId,int periodNo,
                                               int overallScore,String evaluationFormDept){

        EvaluationOfDept evaluationOfDept = new EvaluationOfDept();
        evaluationOfDept.setManagerName(managerName);
        evaluationOfDept.setStudentId(studentId);
        evaluationOfDept.setPeriodNo(periodNo);
        evaluationOfDept.setOverallScore(overallScore);
        evaluationOfDept.setEvaluationFormDept(evaluationFormDept);

        boolean flag = evaluationOfDeptService.evaluatingStudentWithManager(evaluationOfDept);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

}
