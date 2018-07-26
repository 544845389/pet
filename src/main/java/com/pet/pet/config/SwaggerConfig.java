package com.pet.pet.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * create by lorne on 2017/8/17
 */
@Configuration
@EnableSwagger2 // 启用 Swagger
//url->http://localhost:8090/swagger-ui.html
public class SwaggerConfig {





    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate =
                new Predicate<RequestHandler>() {
                    @Override
                    public boolean apply(RequestHandler input) {
                        Class<?> declaringClass = input.declaringClass();

                        boolean isController = declaringClass.isAnnotationPresent(Controller.class);
                        boolean isRestController = declaringClass.isAnnotationPresent(RestController.class);
                        String pattern = "com\\.pet\\.pet\\.api..*\\.*Controller";
                        String className = declaringClass.getName();
                        boolean has = Pattern.matches(pattern, className);
                        if (has) {
                            if (isController) {
                                if (input.isAnnotatedWith(ResponseBody.class)) {
                                    return true;
                                }
                            }
                            if (isRestController) {
                                return true;
                            }
                            return false;
                        }

                        return false;
                    }
                };
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("授权令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        //添加head参数end
        return new Docket(DocumentationType.SWAGGER_2)
                .host("127.0.0.1:8090")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build()
                .globalOperationParameters(pars)
                .directModelSubstitute(java.sql.Timestamp.class, java.sql.Date.class)
                .enableUrlTemplating(false);
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("接口文档").version("1.0").build();
    }
}