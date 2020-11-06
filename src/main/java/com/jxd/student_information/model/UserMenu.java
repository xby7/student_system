package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserMenu {
    @TableId
    private int id;
    private String userId;
    private String menuId;
}
