package com.github.lksferreira.apiresttodotask.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components())
                .info(new Info().title("Web API Stefanini - Task Gupy").version("1.0.0")
                        .description("API RESTful para gerenciamento de tarefas").termsOfService("terms")
                        .contact(new Contact().name("Lucas Ferreira").email("lks_ferreira@hotmail.com")
                                .url("https://github.com/LKSFerreira")));
    }

}
