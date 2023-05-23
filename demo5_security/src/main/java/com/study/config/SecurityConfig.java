package com.study.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * springSecurity 配置类
 * @author yangz
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    /**授权*/
    @Override
    protected void configure(HttpSecurity http) throws Exception{
       //首页所有人可以访问，功能页只有对应权限的人才可以访问

        http.authorizeRequests() //认证请求(那些请求只有那些角色访问)
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // .formLogin() 开启（没有权限）没有登录默认到登录页面（spring的）.formLogin()
        //.loginPage("/toLogin") 去自定义的登录页面
        //.usernameParameter("name").passwordParameter("pwd") 自定义接送前端的参数
        http.formLogin().usernameParameter("name").passwordParameter("pwd").loginPage("/toLogin").loginProcessingUrl("/login");

        //防止网站工具： get  post
        http.csrf().disable();//关闭csrf功能

        //开启注销功能 ，成功后跳转指定页面

        http.logout().logoutSuccessUrl("/");

        /*
        开启记住我功能 （原理:添加一个cookie）默认保存两周
        在登录成功后，关闭浏览器，再打开，会自动登录
        .rememberMeParameter("remember") 自定义接送前端的参数
        */
        http.rememberMe().rememberMeParameter("remember");


    }

    /**认证(身份验证)*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据应该从数据库中读取 .jdbcAuthentication
        //.passwordEncoder(new BCryptPasswordEncoder()) 设置密码(bcrypt加密方式)加密
        //.roles("vip2","vip3") 添加用户的权限
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                 //添加用户(虚拟的)
                .withUser("faiz").password(new BCryptPasswordEncoder().encode("555")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
