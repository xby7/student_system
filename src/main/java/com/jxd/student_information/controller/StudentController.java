package com.jxd.student_information.controller;

import com.jxd.student_information.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/getStudentByPage")
    @ResponseBody
    public List<Map<String,Object>> getAllStudentByPage(@Param("student_name") String student_name,
                                                        @Param("class_no") String class_no,
                                                        @Param("curPage") String curPage,
                                                        @Param("pageSize") String pageSize){
        if(class_no == null || "".equals(class_no)){
            class_no="0";
        }
        List<Map<String,Object>> resultValue = studentService.getAllStudentByPage(student_name,Integer.parseInt(class_no),
                Integer.parseInt(curPage),Integer.parseInt(pageSize));

        return resultValue;
    }

    @RequestMapping("/getStudentByName")
    @ResponseBody
    public List<Map<String,Object>> getAllStudentByName(@Param("student_name") String student_name,
                                                        @Param("class_no") String class_no
    ){

        if(class_no == null || "".equals(class_no)){
            class_no="0";
        }
        List<Map<String,Object>> resultValue = studentService.getAllStudent(student_name,Integer.parseInt(class_no));


        return resultValue;
    }


}
