package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class EvaluationOfSchool {

    @TableId
    private Integer id;
    private Integer studentId;
    private Integer classNo;
    private String teacherName;
    private Integer overallScore;
    private String evaluationFormSchool;

}
