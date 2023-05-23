package com.study.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther shkstart
 * @create 2021-11-11-11:10
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean  处理所有的认证和授权判断
    @Bean
    public ShiroFilterFactoryBean GetShiroFilterFactory(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
          ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        /*
            认证过滤器：
			anon：无需认证即可访问，游客身份。
			authc：必须认证（登录）才能访问。
			authcBasic：需要通过 httpBasic 认证。
			user：不一定已通过认证，只要是曾经被 Shiro 记住过登录状态的用户就可以正常发起请求，比如 rememberMe。

			授权过滤器:
			perms：必须拥有对某个资源的访问权限（授权）才能访问。
			role：必须拥有某个角色权限才能访问。
			port：请求的端口必须为指定值才可以访问。
			rest：请求必须是 RESTful，method 为 post、get、delete、put。
			ssl：必须是安全的 URL 请求，协议为 HTTPS。
        */
        //拦截
        Map<String,String> filterMap=new LinkedHashMap<>();

        //设置请求权限
        filterMap.put("/to/a","perms[level:a]");
        filterMap.put("/to/b","perms[level:b]");
        filterMap.put("/to/*","authc");


        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录页面
        bean.setLoginUrl("/tologin");
        //设置登录页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;

    }


    //DefaultWebSecurityManager(管理所有Subject)  2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 自定义过滤器 Realm(用于进行权限信息的验证，我们自己实现)  1
    @Bean
    public UserRealm userRealm(){
        UserRealm realm = new UserRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //属性加密算法为md5
        matcher.setHashAlgorithmName("MD5");
        //设置散列次数
        matcher.setHashIterations(1024);

        realm.setCredentialsMatcher(matcher);
        return realm;
    }


    //Shiro整合thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
