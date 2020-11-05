package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Role {
    @TableId
    private int role;
    private String roleName;
}
