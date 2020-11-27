package com.imooc.miaosha.config;

import java.util.List;

import com.imooc.miaosha.config.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author SQR
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{

    //配置用户参数
    @Autowired
    UserArgumentResolver userArgumentResolver;

    //配置拦截器
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login/to_login");
//                .excludePathP atterns("/login/do_login");
    }
}
