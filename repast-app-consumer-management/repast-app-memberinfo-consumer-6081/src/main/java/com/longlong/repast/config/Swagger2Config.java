package com.longlong.repast.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//描述该网站的信息
                .select() // 查询对外所要提供的接口都是什么(consumer项目的Controller)
                .apis(RequestHandlerSelectors.basePackage("com.longlong.repast.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("订单项目 服务接口")
                .description("提供了项目中所有接口信息")
                .contact(new Contact("longlong", "http://www.longlong.com", "longlong@Gmail.com"))
                .version("1.0 beta")
                .build();
    }
}
