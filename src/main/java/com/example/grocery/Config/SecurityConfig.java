package com.example.grocery.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.grocery.Service.UserService;

import jakarta.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login").permitAll()    
                .requestMatchers("/admin/**").hasRole("ADMIN")   
                .requestMatchers("/user/**").hasRole("USER")     
                .anyRequest().authenticated()   
            )
            .formLogin(form -> form
                .loginPage("/login")   
                .loginProcessingUrl("/login")   
                .defaultSuccessUrl("/loginSuccess", true)   
                .failureUrl("/login?error=true")    
                .permitAll()   
            )
            .logout(logout -> logout  .logoutUrl("/logout")   .logoutSuccessUrl("/login").permitAll())   
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login"))
            );  

        return http.build();
    }
}


