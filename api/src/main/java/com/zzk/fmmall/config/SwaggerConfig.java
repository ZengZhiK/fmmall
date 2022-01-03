package com.zzk.fmmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zzk
 * @create 2021-12-21 11:31
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket getDocket() {
//        List<Parameter> params = new ArrayList<>();
//        ParameterBuilder accessTokenBuilder = new ParameterBuilder();
//        ParameterBuilder refreshTokenBuilder = new ParameterBuilder();
//        accessTokenBuilder.name("accessToken").description("Access Token")
//                .modelRef(new ModelRef("String")).parameterType("header").required(false);
//        refreshTokenBuilder.name("refreshToken").description("Refresh Token")
//                .modelRef(new ModelRef("String")).parameterType("header").required(false);
//        params.add(accessTokenBuilder.build());
//        params.add(refreshTokenBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzk.fmmall.api"))
                .paths(PathSelectors.any())
                .build()
//                .globalOperationParameters(params)
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("《锋迷商城》后端接⼝说明")
                .description("《锋迷商城》接口文档")
                .version("1.0")
                .build();
    }
}
