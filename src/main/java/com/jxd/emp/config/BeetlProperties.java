package com.jxd.emp.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName： BeetlProperties
 * @Description： 读取在application.yml中自定义的beetl相关的配置项，同时给与一个组件注解，让spring容器加载并实例化它
 * @Author： XieJing
 * @Date： 2019/10/25
 * @Vision： 1.0
 */
//没有业务逻辑的类使用万能注解  注解为一个组件
@Component
public class BeetlProperties {

    @Value("${beetl.delimiter-statement-start}")
    private String delimiterStatementStart;

    @Value("${beetl.delimiter-statement-end}")
    private String delimiterStatementEnd;

    /**
     * 把配置项设置到具体的值上
     * @return
     */
    public Properties getProperties() {
        Properties properties = new Properties();
        if (StringUtils.isNotBlank(delimiterStatementStart)) {
            if (delimiterStatementStart.startsWith("\\")) {
                delimiterStatementStart = delimiterStatementStart.substring(1);
            }
            //将我们自己的配置项的值设置到beetl规定的属性上去
            properties.setProperty("DELIMITER_STATEMENT_START", delimiterStatementStart);
        }
        if (StringUtils.isNotBlank(delimiterStatementEnd)) {
            properties.setProperty("DELIMITER_STATEMENT_END", delimiterStatementEnd);
        } else {
            properties.setProperty("DELIMITER_STATEMENT_END", "null");
        }
        return properties;
    }
}
