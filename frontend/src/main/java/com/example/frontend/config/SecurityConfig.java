//package com.example.frontend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/css/**", "/js/**", "/images/**", "/public/**").permitAll()
//                        .requestMatchers("/", "/login", "/register", "/problems").permitAll()
//                        .requestMatchers("/admin/**").hasRole("admin")
//                        .requestMatchers("/problem-setter/**").hasRole("problem_setter")
//                        .requestMatchers("/submit/**").hasAnyRole("participant", "admin", "problem_setter")
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/dashboard")
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                );
//
//        return http.build();
//    }
//}
