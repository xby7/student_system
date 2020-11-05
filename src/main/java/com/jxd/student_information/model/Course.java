package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course{

    @TableId
    private Integer courseId;
    private String courseName;

}
