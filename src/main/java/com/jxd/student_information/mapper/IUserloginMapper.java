package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Userlogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IUserloginMapper extends BaseMapper<Userlogin> {

    boolean insertUserlogin(@Param("role") String role,@Param("password") String password);

    boolean updatePassword(@Param("users") List<Userlogin> users);
}
