package ru.netology.springbootdaohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        UserDetails admin = User.builder()
                .username("Admin")
                .password(encoder().encode("qwerty"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("User")
                .password(encoder().encode("qwerty"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}