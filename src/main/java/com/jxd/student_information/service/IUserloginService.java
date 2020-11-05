package com.jxd.student_information.service;

import com.jxd.student_information.model.Userlogin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserloginService extends IService<Userlogin> {

    boolean addUser(String rolr,String password);

    boolean repassword(List<Userlogin> users);

}
