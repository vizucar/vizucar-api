package org.example.vizucarapi.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .headers(headers -> headers
                        .addHeaderWriter((request, response) -> {
                            response.setHeader("Content-Security-Policy",
                                    "default-src 'self'; connect-src 'self' http://localhost:8080;");
                        })
                )
                .authorizeHttpRequests(request -> request.anyRequest().permitAll());
        return http.build();
    }
}
