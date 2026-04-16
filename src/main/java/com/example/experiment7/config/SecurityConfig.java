package com.example.experiment7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // 🔥 IMPORTANT for H2 console
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            .authorizeHttpRequests(auth -> auth
                // ✅ allow frontend
                .requestMatchers("/", "/index.html", "/css/**", "/js/**").permitAll()

                // ✅ allow H2 console
                .requestMatchers("/h2-console/**").permitAll()

                // ✅ public
                .requestMatchers("/api/public/**").permitAll()

                // 🔐 secured
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/admin/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )

            // ❌ REMOVE POPUP
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((req, res, ex2) ->
                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
                )
            )

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // ✅ plain password for now (matches data.sql)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}