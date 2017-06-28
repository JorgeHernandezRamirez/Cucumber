package com.jorgehernandezramirez.bdd.cucumber.configuration;

import com.jorgehernandezramirez.bdd.cucumber.service.IUserService;
import com.jorgehernandezramirez.bdd.cucumber.service.InMemmoryUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    public UserConfiguration(){
        //Para Spring
    }

    @Bean
    public IUserService buildUserService(){
        return new InMemmoryUserService();
    }
}
