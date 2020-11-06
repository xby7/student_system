package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Manager {

    @TableId
    private Integer managerId;
    private String managerName;
    private Integer deptNo;

}
