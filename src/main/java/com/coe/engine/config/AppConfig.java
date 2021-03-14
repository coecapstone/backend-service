package com.coe.engine.config;

import com.coe.engine.repository.StaticRepo;
import com.coe.engine.repository.LoginRepo;
import com.coe.engine.service.StaticService;
import com.coe.engine.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    StaticService formService() {
        return new StaticService();
    }

    @Bean
    LoginService loginService() {
        return new LoginService();
    }

    @Bean
    public StaticRepo formRepo() {
        return new StaticRepo();
    }

    @Bean
    public LoginRepo loginRepo() {
        return new LoginRepo();
    }
}
