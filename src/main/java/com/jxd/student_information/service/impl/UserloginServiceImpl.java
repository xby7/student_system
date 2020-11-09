package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IUserloginMapper;
import com.jxd.student_information.model.Userlogin;
import com.jxd.student_information.service.IUserloginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class UserloginServiceImpl extends ServiceImpl<IUserloginMapper, Userlogin> implements IUserloginService {

    @Autowired
    IUserloginMapper userloginMapper;


    @Override
    public boolean repassword(List<Userlogin> users) {
        return userloginMapper.updatePassword(users);
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        return userloginMapper.deleteUserById(userId);
    }

    @Override
    public List<Userlogin> getAllUserlogin() {
        return userloginMapper.selectAll();
    }
}
