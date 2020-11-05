package com.jxd.student_information.controller;

import com.jxd.student_information.model.Student;
import com.jxd.student_information.service.IStudentService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jxd.student_information.utils.ImgUtil;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    Student student =new Student();
    ImgUtil imgUtil = new ImgUtil();
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

    @RequestMapping("/upload")
    @CrossOrigin
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        // 文件存储位置，文件的目录要存在才行，可以先创建文件目录，然后进行存储
        String filePath = "E:/frontworkspace/myfenli/src/assets/images/uplaod";

        File file =new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        // 文件存储
        //上传文件项
        //获取上传文件的名称
        String filename = multipartFile.getOriginalFilename();
        System.out.println("filename:"+filename);
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename=uuid+"-"+filename;
        System.out.println("filename:"+filename);
        //完成上传文件
        File newFile= new File(filePath,filename);
        multipartFile.transferTo(newFile);
        String imagePath = newFile.getAbsolutePath().replaceAll("\\\\", "/");
        imgUtil.setImgpath(imagePath);
        System.out.println(imagePath);
        //返回文件名 前台通过固定地址+文件名的方法访问该图片 存储使用的是相对路径
        return imagePath;
    }

    @RequestMapping("/addStudents")
    @ResponseBody
    public boolean addStudents(String student_name,
                               String class_no,
                               String sex,
                               String folk,
                               String marital_status,
                               String id_number,
                               String graduate_school,
                               String birthday,
                               String major,
                               String native_place,
                               String img_path,
                               String remark
                              ) {
        Integer classNo = 47;
        student.setStudentName(student_name);
        student.setStudentId(10);
        student.setClassNo(classNo);
        student.setBirthday(birthday.substring(0,10));
        student.setFolk(folk);
        student.setGraduateSchool(graduate_school);
        student.setIdNumber(id_number);
        student.setMajor(major);
        student.setMaritalStatus(marital_status);
        student.setNativePlace(native_place);
        student.setRemark(remark);
        img_path = imgUtil.getImgpath().substring(30);
        student.setImgPath(img_path);
        System.out.println(student.getImgPath());
        student.setSex(sex);

        return studentService.addStudents(student);
    }

    @RequestMapping("/delStudent")
    @ResponseBody
    public boolean delStudent(String student_id){
        Integer studentId = Integer.parseInt(student_id);
        return studentService.delStudent(studentId);
    }




}
