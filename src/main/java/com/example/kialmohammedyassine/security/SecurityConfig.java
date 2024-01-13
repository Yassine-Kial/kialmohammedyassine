package com.example.kialmohammedyassine.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {




    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user,admin);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
        return http

                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> {
                    auth.requestMatchers("/customer/add").authenticated();
                    auth.requestMatchers("/customer/**").hasRole("USER");
                    auth.requestMatchers("/order/**").hasRole("USER");
                    auth.requestMatchers("/customer/delete/*").hasRole("ADMIN");
                    auth.requestMatchers("/order/delete/*").hasRole("ADMIN");
                    auth.requestMatchers("/cash/delete/*").hasRole("ADMIN");

                    auth.anyRequest().authenticated();

                })


                .httpBasic(Customizer.withDefaults())
                .build();

    }
}
