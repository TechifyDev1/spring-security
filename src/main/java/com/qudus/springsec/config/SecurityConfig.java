package com.qudus.springsec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.qudus.springsec.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    // This is where we can configure the security filter chain
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

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setUserDetailsService(userDetailsService());
       provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
       return provider;
    }


    // Configure in memory authentication
    // This is where we can add users to the in memory database
    // @Bean
    // public UserDetailsService userDetailsService() {


    //     // Creating users with defferent roles
    //     // The password is encoded with the default password encoder but in a real application, you should use a stronger password encoder
    //     UserDetails user1 = User
    //         .withDefaultPasswordEncoder()
    //         .username("qudus")
    //         .password("qudus")
    //         .roles("USER")
    //         .build();
    //     UserDetails user2 = User
    //         .withDefaultPasswordEncoder()
    //         .username("qudus2")
    //         .password("qudus2")
    //         .roles("ADMIN")
    //         .build();
    //     // Create an in memory user details manager
    //     return new InMemoryUserDetailsManager(user1, user2);
    // }
}
