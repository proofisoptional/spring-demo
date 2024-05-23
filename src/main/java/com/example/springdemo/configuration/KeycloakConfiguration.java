package com.example.springdemo.configuration;


import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
    @Value("${keycloak.server-url}")
    public String serverUrl;
    @Value("${keycloak.realm}")
    public String realm;
    @Value("${keycloak.clientId}")
    public String clientId;
    @Value("${keycloak.secret}")
    public String clientSecret;
    @Value("${keycloak.username}")
    public String username;
    @Value("${keycloak.password}")
    public String password;

    @Bean
    public Keycloak keycloak(){
        return KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl(serverUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .build();
    }
}
