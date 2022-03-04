package com.example.rankapi.Configurations;

import com.example.rankapi.User.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private SufixConfiguration sufixConfiguration;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl, SufixConfiguration encodeService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.sufixConfiguration = encodeService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(sufixConfiguration.getPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register")
                .permitAll();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home",true)
                .successForwardUrl("/home");

        http.authorizeRequests()
                .antMatchers("/", "/home/*", "/alert/*", "/scheduler/*", "/agent/*", "/ftp/*", "/smtp/*", "/sql/*").access("hasRole('USER')");

        http.authorizeRequests()
                .antMatchers("/clicker")
                .authenticated();
        http.csrf().disable();
    }
}


