package com.jxd.student_information.controller;


import com.jxd.student_information.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class MenuController {
    @Resource
    private IMenuService menuService;

    /**
     * 获取菜单
     *
     * @param userId 人员id
     * @return list
     */
    @RequestMapping("/Aside/getMenus")
    @ResponseBody
    public List<Map<String, Object>> getMenus(String userId) {



        return menuService.queryMenuInfo(userId);
    }
}
