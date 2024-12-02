package com.digital_libary.Digital_Library.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Digital_Library")
                        .version("v1.0")
                        .description("This API enables efficient management of books, providing CRUD operations")
                        .termsOfService("http://example.com/terms")
                        .contact(
                                new Contact()
                                        .url("https://www.linkedin.com/in/benovse-balammedova/")
                                        .email("benovse.balammedova.02@gmail.com")
                                        .name("Benovse Balammedova")

                        )
        );
    }
}


