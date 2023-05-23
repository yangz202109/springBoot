package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yangz
 * 扩展springmvc
 */
@Configuration
public class MyConfig implements WebMvcConfigurer{
    /**
     * 接管指定请求的 controller
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //相当于一Xxxcontroller
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 添加自定义国际化组件
     */
    @Bean
    public LocaleResolver localeResolver(){
       return new MyLocaleResolver();
    }

    /**
     * 接管拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/img/**","/js/**");//哪些不拦截
    }
}

