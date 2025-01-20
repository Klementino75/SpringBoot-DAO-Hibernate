package ru.netology.springbootdaohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authorizeRequests) -> authorizeRequests
                        .requestMatchers(HttpMethod.GET, "/persons/by-name-surname/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/persons/by-city/**",
                                "/persons/by-age/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/persons/hello/**").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("Admin")
                .password("{noop}qwerty")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.builder()
                .username("Andrew")
                .password("{noop}asdfg")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}