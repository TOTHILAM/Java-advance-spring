package com.vti.springframework.configuration;

import com.vti.springframework.entity.User;
import com.vti.springframework.exception.ErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain (
            HttpSecurity http, ErrorHandler errorHandler
    ) throws Exception {
        http
                .csrf(customizer -> customizer.disable())
                .cors(customizer -> {})
                .httpBasic(customizer -> {})
                .sessionManagement(customizer -> customizer
                        .sessionCreationPolicy((SessionCreationPolicy.STATELESS)))
                .exceptionHandling(customizer -> customizer
                        .authenticationEntryPoint(errorHandler)
                        .accessDeniedHandler(errorHandler))
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers(HttpMethod.DELETE)
                        .hasAuthority(User.Role.ADMIN.name())
                        .requestMatchers(HttpMethod.POST, "/api/v1/post/**", "/api/v1/comments/**")
                        .hasAnyAuthority(User.Role.ADMIN.name(), User.Role.MANAGER.name())
                        .requestMatchers(HttpMethod.PUT, "/api/v1/post/**", "/api/v1/comments/**")
                        .hasAnyAuthority(User.Role.ADMIN.name(), User.Role.MANAGER.name())
                        .requestMatchers(HttpMethod.POST, "/api/v1/users")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
