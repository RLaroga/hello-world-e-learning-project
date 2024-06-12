//package com.helloWorld.helloWorld.config.security;
//
//import com.helloWorld.helloWorld.config.PermitAllUrlProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    private PermitAllUrlProperties permitAllUrl;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf(AbstractHttpConfigurer :: disable)
//                .sessionManagement( configurer -> configurer.sessionCreationPolicy( SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests( customizer -> {
//                    permitAllUrl.getUrls().forEach(url -> customizer.requestMatchers(url).permitAll());
//                    customizer
//                            .requestMatchers("/login").anonymous()
//                            .requestMatchers("/actuator/**").anonymous()
//                            .anyRequest().permitAll();
//                });
//                //todo - to be continue
//
//        return httpSecurity.build();
//    }
//}
