package com.example.demo.config;

import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Override
    final AccountService accountService;
    final PasswordEncoder passwordEncoder;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder);
    }



    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/v1/hello", "api/v1/account/*").permitAll();
        http.authorizeRequests().antMatchers("/api/v1/user" ).hasAnyAuthority("USER", "ADMIN");
        http.authorizeRequests().antMatchers("/api/v1/admin").hasAnyAuthority("ADMIN");
        MyAuthorizationFilter myAuthorizationFilter = new MyAuthorizationFilter();
        http.addFilterBefore(myAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
