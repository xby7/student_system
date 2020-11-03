package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName Role
 * @Description
 * @Author WangYue
 * @Date 2020/11/1
 * @Version 1.0
 */
@Data
public class Role {
    @TableId
    private int role;
    private String roleName;
}
