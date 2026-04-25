package com.webservices.serviciotecnico.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            // Endpoints públicos (Login, Registro y Documentación)
            .antMatchers(
                "/usuarios/login/**",
                "/usuarios/save", 
                "/swagger-ui.html", 
                "/swagger-ui/**", 
                "/api-docs/**", 
                "/v3/api-docs/**",
                "/favicon.ico"
            ).permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
