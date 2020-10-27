package com.jxd.emp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestConfig
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/23
 * @Version 1.0
 */

public class TestConfig {
    public static void main(String[] args) {
        //获取一个person对象

        //加载Spring容器，扫描@Configuration注解的配置类，并将其中@Bean注解的方法的返回值加载到Spring的容器中
        ApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfig.class);
        Person person = (Person) ac.getBean("person");
        System.out.println(person.getName());
    }
}
