package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xby
 * @since 2020-10-30
 */
@Data
public class EvaluationOfDept {

    @TableId
    private Integer id;
    private Integer studentId;
    private String deptName;
    private String job;
    private String managerName;
    private Integer overallScore;
    private String evaluationFormDept;
    private Integer periodNo;

}
