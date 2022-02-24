package com.example.rankapi.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
public class SufixConfiguration {

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();

    }

}
