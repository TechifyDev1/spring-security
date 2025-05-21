package com.qudus.springsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Disable CSRF protection
        http.csrf(customizer -> customizer.disable());

        // Enable all requests should be required to be authenticated
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        // Enable form login
        http.formLogin(Customizer.withDefaults());

        // Enable basic authentication like from postman
        http.httpBasic(Customizer.withDefaults());


        // make session management stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
