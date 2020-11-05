package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Userlogin {

    @TableId
    private Integer userId;
    private String password;
    private String userName;
    private String role;

}
