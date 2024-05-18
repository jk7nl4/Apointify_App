package com.example.Apointify_App.Config;

import com.example.Apointify_App.Entity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRole userRole() {
        return UserRole.CLIENT;
    }
}
