package com.jxd.student_information.controller;

import com.jxd.student_information.model.Dept;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IDeptService;
import com.jxd.student_information.service.IManagerService;
import com.jxd.student_information.service.IQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Controller
public class ManagerController {

    @Autowired
    IManagerService managerService;

    @Autowired
    IDeptService deptService;

    @Autowired
    IQualityService qualityService;

    @RequestMapping("/getAllManager")
    @ResponseBody
    public List<Map<String, Object>> getAllManager(String managerName) {
        return managerService.getAllManagerWithDept_name(managerName);
    }

    @RequestMapping("/getAllManagerByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllManagerByPage(int pageSize, int currentPage, String managerName) {
        return managerService.getAllManagerWithDept_nameByPage(pageSize, currentPage, managerName);
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(String managerName, String deptName) {
        boolean result = managerService.addManager(managerName, deptName);
        if (result == true) {
            return "添加成功";
        } else {
            return "服务器响应失败";
        }
    }

    @RequestMapping("/deleteManager")
    @ResponseBody
    public String deleteManagerById(int managerId) {
        boolean result = managerService.removeById(managerId);
        if (result == true) {
            return "删除成功";
        } else {
            return "服务器响应失败";
        }
    }

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

    @RequestMapping("/updateManagerById")
    @ResponseBody
    public String updateManagerById(int managerId, String managerName, String deptName) {
        boolean result = managerService.updateManagerById(managerId, managerName, deptName);
        if (result == true) {
            return "修改成功";
        } else {
            return "服务器响应失败";
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
