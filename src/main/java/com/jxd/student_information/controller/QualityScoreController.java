package com.jxd.student_information.controller;

import com.jxd.student_information.model.QualityScore;
import com.jxd.student_information.service.IQualityScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
public class QualityScoreController {
    @Autowired
    private IQualityScoreService qualityScoreService;

    /**
     * 获取单个学生的品质分数信息===经理
     * @param studentId 学生id
     * @param periodNo  工作时期
     * @return
     * @Author cbb
     */
    @RequestMapping("/getScoreByStudentIdWithManager")
    @ResponseBody
    public List<Map<String, Object>> getScoreByStudentIdWithManager(int studentId,int periodNo){
        //List<Map<String, Object>> qualityScoreWithStudent = qualityScoreService.getScoreWithManagerByStudentId(studentId,periodNo);
        /*Map<String, Object> map = new HashMap<>();
        map.put("qualityScoreWithStudent",qualityScoreWithStudent);*/
        return qualityScoreService.getScoreWithManagerByStudentId(studentId,periodNo);
    }


    /**
     * 对品质的打分===经理
     * @param qualityScores 前台传回的json对象
     * @return
     * @Author cbb
     */
    @RequestMapping("/updateStuScoreWithManager")
    @ResponseBody
    public String updateStuScoreWithManager(@RequestBody()List<QualityScore> qualityScores){
        boolean flag = qualityScoreService.updateStuScoreWithManager(qualityScores);
        if (flag) {
            return "success";
        } else {
            return "error";
        }
    }

}
