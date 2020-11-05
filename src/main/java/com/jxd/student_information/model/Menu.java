package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Menu {

    /*
        menuId       表示当前菜单项 ID
        parentId     表示父菜单项 ID
        nameZh      表示菜单名（中文）
        nameEn       表示菜单名（中文）
        url          表示路由跳转路径（自身模块 或者 外部 url）
        type         表示当前菜单项的级别（0: 目录，1: 菜单项，2: 按钮）
        icon         表示当前菜单项的图标
        orderNum     表示当前菜单项的顺序
    */
    @TableId
    private int menu_id;

    private String url;
    private String nameEn;
    private String nameZh;
    private String icon;
    private String component;
    private int parentId;
    private int type;
    private int orderNum;
}
