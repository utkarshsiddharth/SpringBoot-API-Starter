package com.skdev.config;

import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfigImpl {

    @Value("http://localhost:8080")
    private String devUrl;

    @Value("https://springboot-starter.app")
    private String prodUrl;


    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("shubhamkashyapdev@gmail.com");
        contact.setName("dev1800");
        contact.setUrl("https://shubhamkashyapdev.vercel.app");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("SpringBoot 3 API Starter Template")
                .version("1.0")
                .contact(contact)
                .description("SpringBoot 3 API Template With PostgreSQL, JWT Authentication and Swagger Setup").termsOfService("https://shubhamkashyapdev.vercel.app/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}