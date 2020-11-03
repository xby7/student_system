package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName UserMenu
 * @Description
 * @Author WangYue
 * @Date 2020/10/31
 * @Version 1.0
 */
@Data
public class UserMenu {
    @TableId
    private int id;
    private String userId;
    private String menuId;
}
