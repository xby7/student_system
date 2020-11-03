package com.jxd.student_information.controller;

import com.jxd.student_information.jwt.JwtUtil;
import com.jxd.student_information.model.Userlogin;
import com.jxd.student_information.service.IUserloginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@CrossOrigin
@Controller
public class UserloginController {

    @Autowired
    private IUserloginService userloginService;

    //定义一个密令字符串
    //private static final String SECRET = "**********模拟token****拦截器不生效，拦截后无法进入Controller*********" ;


    //修改密码
    @RequestMapping("/updateUserPassword")
    @ResponseBody
    public String updateUserPWD(int userId,String newPassword){
        Userlogin userlogin = new Userlogin();
        userlogin.setUserId(userId);
        userlogin.setPassword(newPassword);
        boolean flag = userloginService.updateById(userlogin);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //登录验证，返回成功信息，返回用户信息（姓名权限等）
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(int userId, String password) {

        //测试一
        //System.out.println("---");
        //System.out.println(userId + "-" + password);

        Userlogin userlogin = userloginService.getById(userId);
        Map<String, Object> map = new HashMap<>();
        if (userlogin != null && userlogin.getPassword().equals(password)) {
            String token = JwtUtil.getJwtToken(userId);

            //测试二  数据
            System.out.println("***********************************************" +
                    "\n登录用户Id" + userlogin.getUserId());

            map.put("userlogin", userlogin);
            map.put("message", "success");
            map.put("token", token);
            return map;
        } else {
            map.put("message", "用户名或密码错误");
            return map;
        }
    }


}
