package com.example.backend.config;

import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.service.UserService;
import com.example.backend.utils.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class PersistenceConfig {

    UserService userService;

    public PersistenceConfig(UserService userService){
        this.userService = userService;
    }

    @Bean
    AuditorAware<UserEntity> auditorProvider() {
        return new AuditorAwareImpl(userService);
    }

}