package org.example.vizucarapi.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/cars/**")
                .allowedOrigins("http://localhost:5123")
                .allowedMethods("GET")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
