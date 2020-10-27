package com.jxd.emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName EmpApplication
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/22
 * @Version 1.0
 */
@SpringBootApplication  //当前类变为启动类
/*@ComponentScan(basePackages = "com.jxd")*/
@MapperScan("com.jxd.emp.mapper")   //扫描所有的mapper层 xml 文件
public class EmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class);
    }
}
