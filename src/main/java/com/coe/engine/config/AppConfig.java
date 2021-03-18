package com.coe.engine.config;

import com.coe.engine.repository.FormRepo;
import com.coe.engine.repository.StaticRepo;
import com.coe.engine.repository.LoginRepo;
import com.coe.engine.service.FormService;
import com.coe.engine.service.StaticService;
import com.coe.engine.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    FormService formService() {
        return new FormService();
    }

    @Bean
    LoginService loginService() {
        return new LoginService();
    }

    @Bean
    StaticService staticService() {
        return new StaticService();
    }

    @Bean
    public StaticRepo staticRepo() {
        return new StaticRepo();
    }

    @Bean
    public LoginRepo loginRepo() {
        return new LoginRepo();
    }

    @Bean
    public FormRepo formRepo() {
        return new FormRepo();
    }
}
