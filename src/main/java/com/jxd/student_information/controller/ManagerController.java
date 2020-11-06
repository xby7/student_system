package com.jxd.student_information.controller;

import com.jxd.student_information.model.Dept;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IDeptService;
import com.jxd.student_information.service.IManagerService;
import com.jxd.student_information.service.IQualityService;
import com.jxd.student_information.service.IUserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {

    @Autowired
    IManagerService managerService;
    @Autowired
    IDeptService deptService;
    @Autowired
    IUserloginService userloginService;
    @Autowired
    IQualityService qualityService;

    //xby
    @RequestMapping("/getAllManager")
    @ResponseBody
    public List<Map<String, Object>> getAllManager(String managerName) {
        return managerService.getAllManagerWithDept_name(managerName);
    }

    //xby
    @RequestMapping("/getAllManagerByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllManagerByPage(int pageSize, int currentPage, String managerName) {
        return managerService.getAllManagerWithDept_nameByPage(pageSize, currentPage, managerName);
    }

    //xby

    /**
     * 添加部门主管信息时，将该主管 id 作为用户名，默认密码
     * ，以及主管权限等级"2" 插入到用户登陆表中
     * 该主管 id 通过 sql 语句查询
     */
    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(String managerName, String deptName) {
        String role = "2"; //部门主管的权限等级
        String password = "123456"; //默认密码
        boolean result = managerService.addManager(role,password,managerName, deptName);
        if (result == true) {
            return "添加成功";
        } else {
            return "添加失败，请稍后再试";
        }
    }

    //xby
    @RequestMapping("/deleteManager")
    @ResponseBody
    public String deleteManagerById(int managerId) {
        boolean result = managerService.removeById(managerId);
        if (result == true) {
            return "删除成功";
        } else {
            return "删除失败，请稍后再试";
        }
    }

    //xby

    /**
     * @return 返回的是一个 map ，包含 managerId 、managerName 、和 部门名称（部门表中的数据）
     */
    @RequestMapping("/getManagerById")
    @ResponseBody
    public Map<String, Object> getManagerById(int managerId) {
        Manager manager = managerService.getById(managerId);
        Dept dept = deptService.getById(manager.getDeptNo());
        Map<String, Object> map = new HashMap<>();
        map.put("managerId", manager.getManagerId());
        map.put("managerName", manager.getManagerName());
        map.put("deptName", dept.getDeptName());
        return map;
    }

    //xby
    @RequestMapping("/updateManagerById")
    @ResponseBody
    public String updateManagerById(int managerId, String managerName, String deptName) {
        boolean result = managerService.updateManagerById(managerId, managerName, deptName);
        if (result == true) {
            return "修改成功";
        } else {
            return "修改成功，请稍后再试";
        }
    }


    /**
     * 获取学生信息===经理
     * @param studentName  学生姓名
     * @param managerId 经理id
     * @param periodNo  工作时期
     * @param curPage   分页的两个参数
     * @param pageSize
     * @return
     * @Author cbb
     */
    @RequestMapping("/getAllStuWithManager")
    @ResponseBody
    public Map<String, Object> getAllStuWithManager(String studentName,int managerId,int periodNo,
                                                    int curPage, int pageSize){
        curPage = curPage == 0 ? 1 : curPage;
        pageSize = pageSize == 0 ? 5 : pageSize;

        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> totals = managerService.getAllStuTotalsWithManager(studentName,managerId,periodNo);
        List<Map<String, Object>> students = managerService.getAllStuWithManagerByPage(studentName, managerId, periodNo,
                                                                                        curPage, pageSize);
        List<Map<String, Object>> tableColumnList = qualityService.getAllQualityName();

        map.put("students", students);
        map.put("total", totals);
        map.put("tableNameList", tableColumnList);
        return map;
    }
}
