package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class EvaluationOfDept {

    @TableId
    private Integer id;
    private Integer studentId;
    private Integer deptNo;
    private String job;
    private String managerName;
    private Integer overallScore;
    private String evaluationFormDept;
    private Integer periodNo;

}
