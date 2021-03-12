package com.coe.engine.config;

import com.coe.engine.repository.FormRepo;
import com.coe.engine.service.FormService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    FormService formService() {
        return new FormService();
    }

    @Bean
    public FormRepo formRepository() {
        return new FormRepo();
    }
}
