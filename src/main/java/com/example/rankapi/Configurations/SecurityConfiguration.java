package com.example.rankapi.Configurations;

import com.example.rankapi.User.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
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
                .defaultSuccessUrl("/home",true)
                .successForwardUrl("/home")
                .failureForwardUrl("/login");

        http.authorizeRequests().antMatchers("/home").authenticated();
        http.authorizeRequests().antMatchers("/clicker").permitAll();
        http.csrf().disable();
    }
}


