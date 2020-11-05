package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Teacher {

    @TableId
    private Integer teacherId;
    private String teacherName;

}
