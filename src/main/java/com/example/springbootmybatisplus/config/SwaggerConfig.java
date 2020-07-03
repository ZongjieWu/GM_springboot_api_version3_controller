package com.example.springbootmybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {

        //用户设置局部token 方式1 //已用下面方式2更通用
        ParameterBuilder ticketPar = new ParameterBuilder();
        ParameterBuilder timestampPar = new ParameterBuilder();
        ParameterBuilder noncePar = new ParameterBuilder();
        ParameterBuilder signPar= new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name("version").description("版本号")
//                .modelRef(new ModelRef("string")).parameterType("path")
//                .required(true).build(); //header中的ticket参数非必填，传空也可以
        timestampPar.name("timestamp").description("时间戳")
                .modelRef(new ModelRef("int")).parameterType("query")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        noncePar.name("nonce").description("随机字符串(请求id)")
                .modelRef(new ModelRef("string")).parameterType("query")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        signPar.name("sign").description("签名")
                .modelRef(new ModelRef("string")).parameterType("query")
                .required(false).build(); //header中的ticket参数非必填，传空也可以

//        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        pars.add(timestampPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        pars.add(noncePar.build());    //根据每个方法名也知道当前方法在设置什么参数
        pars.add(signPar.build());    //根据每个方法名也知道当前方法在设置什么参数


        return new Docket(DocumentationType.SWAGGER_2)
//                .host("http://127.0.0.1:8082")
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootmybatisplus.web.controller"))
                .paths(PathSelectors.any())
                .build()
                //配置认证的暂时取消
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(pars);
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("swagger管理接口")
                //创建人
                .contact(new Contact("ZongjieWu", "baidu.com", "2012293155@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("用于做示例教程")
                .build();
    }


    /*
     *########################################
     * 以下配置认证设置全局token和局部token/方式2
     * ######################################
     **/
    private List<ApiKey> securitySchemes() {

//        return new ArrayList(
//                Collections.singleton(new ApiKey("Authorization", "token", "header"))
//        );
       List<ApiKey> apiKeyList=new ArrayList<>();
       apiKeyList.add(new ApiKey("Authorization", "token", "header"));
       apiKeyList.add(new ApiKey("Version", "version", "header"));
       return apiKeyList;
    }
    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        );
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList(
                Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }

}