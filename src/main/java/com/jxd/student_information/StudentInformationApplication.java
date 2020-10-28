package com.jxd.student_information;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName StudentInformationApplication
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/28
 * @Version 1.0
 */

@SpringBootApplication  //当前类变为启动类
@MapperScan("com.jxd.student_information.mapper")   //扫描所有mapper接口
public class StudentInformationApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentInformationApplication.class);
    }
}
