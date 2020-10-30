package com.jxd.student_information.controller;

import com.jxd.student_information.model.Userlogin;
import com.jxd.student_information.service.IUserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Controller
public class UserloginController {

    @Autowired
    private IUserloginService userloginService;


    @RequestMapping("/updateUserPWD/{user_id}/{newPWD}")
    @ResponseBody
    public String updateUserPWD(@PathVariable("user_id") int user_id,@PathVariable("newPwd") String newPWd){
        Userlogin userlogin = new Userlogin();
        userlogin.setUserId(user_id);
        userlogin.setPassword(newPWd);
        boolean flag = userloginService.updateById(userlogin);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

}
