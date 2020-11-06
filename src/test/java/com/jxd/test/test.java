package com.jxd.test;

import com.jxd.student_information.StudentInformationApplication;
import com.jxd.student_information.mapper.ITeacherMapper;
import com.jxd.student_information.mapper.IUserloginMapper;
import com.jxd.student_information.model.Userlogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @ClassName test
 * @Description TODO
 * @Author caibaobiao
 * @Date 2020/10/28
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentInformationApplication.class)
public class test {

    @Autowired
    private IUserloginMapper userloginMapper;

    @Autowired
    private ITeacherMapper teacherMapper;

   /* @Test
    public void test() {
        Userlogin userlogin = new Userlogin();
        userlogin.setUser_id(123);
        userlogin.setPassword("123456");
        userloginMapper.updateById(userlogin);
    }*/

   /* @Test
    public void test02() {
        List<Map<String, Object>> list = teacherMapper.selectAllStu();

        for (Map map : list) {
            System.out.println(map.get("course_name") + "\n"+map.get("teacher_name"));
        }
    }*/
}
