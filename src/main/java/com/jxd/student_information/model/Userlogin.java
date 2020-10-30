package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class Userlogin {
    //告诉mp表的主键是什么
    @TableId
    private Integer user_id;

    private String password;

    private String user_name;

    private String role;

    public Userlogin() {
    }

    public Userlogin(Integer user_id, String password, String user_name, String role) {
        this.user_id = user_id;
        this.password = password;
        this.user_name = user_name;
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
