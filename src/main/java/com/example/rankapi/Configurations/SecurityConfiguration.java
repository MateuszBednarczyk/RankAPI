package com.example.rankapi.Configurations;

import com.example.rankapi.Services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private SufixConfiguration encodeService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl, SufixConfiguration encodeService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.encodeService = encodeService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encodeService.getPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/*").permitAll();
        http.formLogin().loginPage("/login").successForwardUrl("/home").permitAll();
        http.csrf().disable();
    }
}
