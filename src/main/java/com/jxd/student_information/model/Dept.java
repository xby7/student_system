package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dept {

    @TableId
    private Integer deptNo;
    private String deptName;

}
