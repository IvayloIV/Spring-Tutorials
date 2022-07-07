package com.pluralsight.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {

    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.ant("/v2/**"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getAppInfo("2.0"));
    }

    private ApiInfo getAppInfo(String version) {
        return new ApiInfoBuilder()
            .title("Application API")
            .version(version)
            .description("API for managing applications.")
            .contact(new Contact("Ivaylo Ivanov", "https://google.com", "ivaylo@abv.bg"))
            .license("Apache License Version 2.0")
            .build();
    }
}
