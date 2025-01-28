package ru.netology.springbootdaohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity( jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(
                (authorizeRequests) -> authorizeRequests
                        .requestMatchers("/persons/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("Admin")
                .password(encoder().encode("qwerty"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("User")
                .password(encoder().encode("qwerty"))
                .roles("READ")
                .build());

        manager.createUser(User.withUsername("Ivan")
                .password(encoder().encode("qwerty"))
                .roles("READ", "WRITE")
                .build());

        manager.createUser(User.withUsername("Sergey")
                .password(encoder().encode("qwerty"))
                .roles("WRITE", "DELETE")
                .build());

        manager.createUser(User.withUsername("Anna")
                .password(encoder().encode("qwerty"))
                .roles("READ", "DELETE")
                .build());

        return manager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}