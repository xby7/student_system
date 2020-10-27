package com.jxd.emp.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyBeetlConfig
 * @Description:TODO
 * @Author: lixiaoru
 * @Date: 2019/11/21
 * @Version: 1.0
 */

@Configuration
public class MyBeetlConfig {
    @Autowired
    private BeetlProperties beetlProperties;

    @Value("${spring.mvc.view.prefix}")
    private String prefix;
    /**
     * beetl的配置
     */
    @Bean(name="beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        //获取Spring Boot 的类加载器ClassLoader
        //ClassLoader类的介绍可以总结出这个类的作用就是根据一个指定的类的全限定名,
        // 找到对应的Class字节码文件,然后加载它转化成一个java.lang.Class类的一个实例.
        //java的类加载机制（jvm规范）是委托模型，简单的说，如果一个类加载器想要加载一个类，首先它会委托给它的parent去加载，
        // 如果它的所有parent都没有成功的加载那么它才会自己亲自来，有点儿像儿子使唤老子的感觉。
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = MyBeetlConfig.class.getClassLoader();
        }
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader, prefix);
        beetlGroupUtilConfiguration.setResourceLoader(cploder);

        //设置自定义的配置，可以覆盖默认配置
        beetlGroupUtilConfiguration.setConfigProperties(beetlProperties.getProperties());
        beetlGroupUtilConfiguration.init();
        return beetlGroupUtilConfiguration;
    }
    /**
     * beetl的视图解析器
     */
    @Bean
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }
}
