package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xby
 * @since 2020-10-30
 */
@Data
public class Userlogin {
    //告诉mp表的主键是什么
    @TableId
    private Integer userId;
    private String password;
    private String userName;
    private String role;

}
