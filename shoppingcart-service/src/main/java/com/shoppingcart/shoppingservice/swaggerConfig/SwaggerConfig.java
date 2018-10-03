/*package com.shoppingcart.shoppingservice.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shoppingcart.shoppingservice.constant.Constants;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shoppingcart.shoppingservice.restcontrollers"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
        		Constants.SWAGGER_TITLE,
                Constants.SWAGGER_DESCRIPTION,
                Constants.SWAGGER_APP_VERSION,
                Constants.SWAGGER_TERMS_SERVICE_URL,
                new Contact(Constants.SWAGGER_DEV_TEAM_NAME_LIST, Constants.SWAGGER_PROJECT_GIT_REPO,
                        Constants.SWAGGER_TEAM_EMAIL_LIST), Constants.SWAGGER_APP_LICENCE,
                        Constants.SWAGGER_APP_LICENCE_URL);
    }
}*/