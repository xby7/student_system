package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Quality {

    @TableId
    private Integer qualityId;
    private String qualityName;

}
