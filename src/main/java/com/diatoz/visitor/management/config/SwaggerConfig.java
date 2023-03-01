package com.diatoz.visitor.management.config;

import com.google.common.base.Predicate;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {



    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("VisitorManagement-scheduler")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("VisitorManagement-Scheduler")
                        .description("VisitorManagement-Scheduler Portal")
                        .version("v0.0.1")
                        //.license(new License().name("Apache 2.0").url("http://springdoc.org")))
                        //.externalDocs(new ExternalDocumentation()
                        .description("This is the Description of VisitorManagement-Scheduler"));
        //.url("https://springshop.wiki.github.org/docs"));
    }
}