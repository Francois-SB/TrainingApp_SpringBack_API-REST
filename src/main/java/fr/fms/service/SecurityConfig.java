package fr.fms.service;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().permitAll();
    }
}
