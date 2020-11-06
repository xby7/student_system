package com.jxd.student_information.service;

import com.jxd.student_information.model.Userlogin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IUserloginService extends IService<Userlogin> {

    boolean repassword(List<Userlogin> users);

}
