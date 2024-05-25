package com.example.springdemo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defaultOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8087");
        server.setDescription("Development Server");

        Contact contact = new Contact();
        contact.setName("Tamerlan Shamelov");
        contact.setEmail("tshamelov@gmail.com");

        Info info = new Info().title("Profile Management System").version("1.0")
                .description("API to manage profiles")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
