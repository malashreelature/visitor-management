package com.diatoz.visitor.management.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


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
                        .description("This is the Description of VisitorManagement-Scheduler"));
    }
}