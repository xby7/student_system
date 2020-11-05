package com.jxd.student_information.controller;

import com.jxd.student_information.model.Userlogin;
import com.jxd.student_information.service.IUserloginService;
import com.jxd.student_information.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String updateUserPWD(int userId, String newPassword) {
        Userlogin userlogin = new Userlogin();
        userlogin.setUserId(userId);
        userlogin.setPassword(newPassword);
        boolean flag = userloginService.updateById(userlogin);
        if (flag) {
            return "success";
        } else {
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

    //xby
    @RequestMapping("/getAllUserlogin")
    @ResponseBody
    public List<Userlogin> getAllUserlogin() {
        return userloginService.list();
    }

    //xby

    /**
     * @param users 前台以 json 形式传递（需要用 @RequestBody 注解接收）过来的用户信息，
     */
    @RequestMapping("/repassword")
    @ResponseBody
    public String repassword(@RequestBody List<Userlogin> users) {
        boolean result = userloginService.repassword(users);
        if (result == true) {
            return "密码重置成功";
        } else {
            return "密码重置失败，请稍后再试";
        }
    }
}
