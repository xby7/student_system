package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Userlogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserloginMapper extends BaseMapper<Userlogin> {

    boolean updatePassword(@Param("users") List<Userlogin> users);
}
