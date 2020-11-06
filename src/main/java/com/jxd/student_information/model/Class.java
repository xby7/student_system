package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Class {

    @TableId
    private Integer classNo;
    private Integer teacherId;

}
