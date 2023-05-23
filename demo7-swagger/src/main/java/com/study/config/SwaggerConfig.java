package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger
 *
 * @author yangz
 */
@Configuration
@EnableOpenApi  //开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() //select--apis--build: RequestHandlerSelectors 配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.study.controller"))//以包的方式
                //.paths(PathSelectors.ant("/user/**"))//过滤请求  只扫描以下请求
                .build()
                .groupName("faiz")
                .enable(b)//是否自动启动Swagger
                ;
    }


    //.groupName("A") 多个Docket即可配置多个分组
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    /**配置Swagger信息---apiInfo  自定义信息*/
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("faiz", "", "");

        return new ApiInfo(
                "My Swagger API文档",
                "一个文档",
                "3.0",
                "https://www.bilibili.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
