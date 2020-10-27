package com.jxd.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DemoConfig
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/23
 * @Version 1.0
 */
@Configuration
public class DemoConfig {
    //一个配置类可以代表一个 xml 文件

    //一个方法代表也一个 bean 标签
    //这个方法返回的对象会被加载到 Spring 容器中
    @Bean(name = "person")  //指定当前bean组件的id
    public Person getPerson(){
        return new Person("张三","男");
    }
}
