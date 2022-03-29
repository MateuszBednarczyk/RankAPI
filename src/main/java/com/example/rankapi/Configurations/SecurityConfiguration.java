package com.example.rankapi.Configurations;

import com.example.rankapi.Authentication.Authorization;
import com.example.rankapi.Authentication.JwtAuthenticationFilter;
import com.example.rankapi.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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

    //spring security logs enable
    @Value("${spring.websecurity.debug:false}")
    boolean webSecurityDebug;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(webSecurityDebug);
    }

    //set userdetailsservice and password encoder to be used
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(sufixConfiguration.getPasswordEncoder());

    }

    //configs
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //login and register
                .antMatchers("/register")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
                //cookies
                .and()
                .rememberMe()
                .rememberMeCookieName("remember")
                .tokenValiditySeconds(86400)
                        .and()
                                .addFilter(new Authorization(authenticationManager()))
                                        .addFilter(new JwtAuthenticationFilter(authenticationManager()));

                //permissions
        http.authorizeRequests().antMatchers().authenticated();
        http.authorizeRequests()
                .antMatchers("/clicker", "/home")
                .authenticated();
        http.csrf().disable();
    }
}


