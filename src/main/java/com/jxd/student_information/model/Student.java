package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Student {

    @TableId
    private Integer studentId;
    private String studentName;
    private String sex;
    private String folk;
    private String birthday;
    private String nativePlace;
    private String maritalStatus;
    private String idNumber;
    private String graduateSchool;
    private String major;
    private String imgPath;
    private String remark;
    private Integer classNo;
    private Integer deptNo;
    private Integer isdeleted;

}
