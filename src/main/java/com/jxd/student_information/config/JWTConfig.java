package com.jxd.student_information.config;


import com.jxd.student_information.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Configuration
public class JWTConfig {


    /**
     * 定义拦截器，拦截请求。
     * 其中：
     * addPathPatterns 用于添加需要拦截的请求。
     * excludePathPatterns 用于添加不需要拦截的请求。
     * 此处：
     * 拦截 除登录请求 的所有请求。
     */
    @Bean(name = "JWTInterceptor")
    public WebMvcConfigurer JWTInterceptor() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new JWTInterceptor())
                        // 拦截所有请求
                        .addPathPatterns("/login/**");
                        // 不拦截 登录 请求
                       //.excludePathPatterns("/login/**");
            }
        };
    }

    /**
     * 定义一个拦截器，用于拦截请求，并对 JWT 进行验证
     */
    class JWTInterceptor extends HandlerInterceptorAdapter {

        /**
         * 访问 controller 前被调用
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            // 获取 token（从 header 或者 参数中获取）
            String token = request.getHeader("token");
            System.out.println("token-1:" + token);
            if (StringUtils.isBlank(token)) {
                token = request.getParameter("token");
                System.out.println("token-2:" + token);
            }
            // 验证 token 是否过期（根据时间戳比较）
            if (JwtUtil.checkToken(token)) {
                System.out.println("剩余时间（秒）:" + (JwtUtil.getTokenBody(token).getExpiration().getTime() - new Date().getTime()) / 1000);
                return true;
            } else {
                //过期，返回
                setCorsMappings(request, response);
                //自定义响应
                response.setStatus(401);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");

                return false;
            }
        }

        //跨域-----------恶心的一批，这个问题调了两天
        private void setCorsMappings(HttpServletRequest request, HttpServletResponse response){
            String origin = request.getHeader("Origin");
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }
    }
}
