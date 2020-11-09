package com.jxd.student_information.controller;

import com.jxd.student_information.model.Student;
import com.jxd.student_information.service.IDeptService;
import com.jxd.student_information.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IDeptService deptService;

    Student student = new Student();

    @RequestMapping("/getStudentByPage")
    @ResponseBody
    public List<Map<String, Object>> getAllStudentByPage(@Param("student_name") String student_name,
                                                         @Param("class_no") String class_no,
                                                         @Param("curPage") String curPage,
                                                         @Param("pageSize") String pageSize) {
        if (class_no == null || "".equals(class_no)) {
            class_no = "0";
        }
        List<Map<String, Object>> resultValue = studentService.getAllStudentByPage(student_name, Integer.parseInt(class_no),
                Integer.parseInt(curPage), Integer.parseInt(pageSize));

        return resultValue;
    }

    @RequestMapping("/getStudentByName")
    @ResponseBody
    public List<Map<String, Object>> getAllStudentByName(@Param("student_name") String student_name,
                                                         @Param("class_no") String class_no
    ) {

        if (class_no == null || "".equals(class_no)) {
            class_no = "0";
        }
        List<Map<String, Object>> resultValue = studentService.getAllStudent(student_name, Integer.parseInt(class_no));


        return resultValue;
    }

    @RequestMapping("/upload")
    @ResponseBody
    @CrossOrigin
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        // 文件存储位置，文件的目录要存在才行，可以先创建文件目录，然后进行存储
        String filePath = "D:/LearnFile/project_final/student_system_front/src/assets/upload";//--------wy
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 文件存储
        //上传文件项
        //获取上传文件的名称
        String filename = multipartFile.getOriginalFilename();
        System.out.println("filename:" + filename);
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "-" + filename;
        System.out.println("filename:" + filename);
        //完成上传文件
        File newFile = new File(filePath, filename);
        multipartFile.transferTo(newFile);
        //返回文件名 前台通过固定地址+文件名的方法访问该图片 存储使用的是相对路径
        return "upload/" + filename;
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
                               String phone,
                               String native_place,
                               String img_path,
                               String remark
    ) {
        student.setStudentName(student_name);
        student.setPhone(phone);
        System.out.println(student.getStudentName() + student.getPhone());
        student.setStudentId(10);
        student.setClassNo(Integer.parseInt(class_no));
        student.setBirthday(birthday.substring(0, 10));
        student.setFolk(folk);
        student.setGraduateSchool(graduate_school);
        student.setIdNumber(id_number);
        student.setMajor(major);
        student.setMaritalStatus(marital_status);
        student.setNativePlace(native_place);
        student.setRemark(remark);
        student.setImgPath(img_path);
        System.out.println("img_path:"+student.getImgPath());
        student.setSex(sex);

        return studentService.addStudents(student);
    }

    @RequestMapping("/delStudent")
    @ResponseBody
    public boolean delStudent(String student_id) {
        Integer studentId = Integer.parseInt(student_id);
        return studentService.delStudent(studentId);
    }


    @RequestMapping("/editStudent")
    @ResponseBody
    public boolean editStudent(String student_id,
                               String student_name,
                               String class_no,
                               String sex,
                               String folk,
                               String marital_status,
                               String id_number,
                               String graduate_school,
                               String birthday,
                               String major,
                               String phone,
                               String native_place,
                               String img_path,
                               String dept_name,
                               String remark
    ) {
        student.setStudentId(Integer.parseInt(student_id));
        student.setStudentName(student_name);
        student.setClassNo(Integer.parseInt(class_no));
        student.setBirthday(birthday.substring(0, 10));
        student.setFolk(folk);
        student.setGraduateSchool(graduate_school);
        student.setIdNumber(id_number);
        student.setMajor(major);
        student.setMaritalStatus(marital_status);
        student.setPhone(phone);
        student.setNativePlace(native_place);
        student.setRemark(remark);
        student.setImgPath(img_path);
        student.setSex(sex);
        student.setDeptNo(deptService.getAllDeptNo(dept_name));

        return studentService.editStudent(student);
    }

    /**
     * 批量删除
     * lk
     */
    @RequestMapping("/delSelect")
    @ResponseBody
    public boolean delSelect(@RequestBody List<Map<String,Object>> students){
        List<Integer> stu_id = new ArrayList<>();
        for (Map<String,Object> stu: students
             ) {
            stu_id.add((Integer)stu.get("student_id"));
        }

        return studentService.delSelectStu(stu_id);
    }

    /**
     * 获取学生信息===用户
     * @param studentId
     * @return
     * @Author cbb
     */
    @RequestMapping("/getStudentWithUserById")
    @ResponseBody
    public Map<String, Object> getStudentWithUserById(int studentId){
        return studentService.getStudentWithUserById(studentId);
    }


}
