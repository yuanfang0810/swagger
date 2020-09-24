package com.hou.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author hou
 * @description
 * @data 2020/9/23 14:51
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }

    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev");
         boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                //配置要扫描的包
                /*
                basePackage("com.hou.swagger.controller")
                扫描方法上的注解
                withMethodAnnotation(GetMapping.class)
                扫描类上的注解
                withClassAnnotation(GetMapping.class)
                过滤路径
                .paths(PathSelectors.ant("/kou/**"))
                */
                //any()扫面全部
                .apis(RequestHandlerSelectors.basePackage("com.hou.swagger.controller"))
//                .paths(PathSelectors.ant("/kou/**"))
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        Contact DEFAULT_CONTACT = new Contact("hkj", "https://www.baidu.com/", "1308560078@qq.com");

        return new ApiInfo(

                "我的api接口文档",
                "即使再小的帆也能远航",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }

}
