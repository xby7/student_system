package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class QualityScore {

    @TableId
    private Integer scoreId;
    private Integer qualityId;
    private Integer studentId;
    private Integer score;

}
