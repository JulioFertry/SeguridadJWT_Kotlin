package com.es.jwtSecurityKotlin.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        return http
            .csrf { csfr -> csfr.disable() } // Cross-Site Forgery
            .authorizeHttpRequests { auth -> auth
                .requestMatchers("rutas_protegidas/**").authenticated()
                .requestMatchers("rutas_publicas/**").permitAll()
                .requestMatchers("secretos/magia_negra").authenticated()
                .requestMatchers("secretos/magia_blanca").permitAll()
                .anyRequest().authenticated()
            } // Los recursos protegidos y publicos
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .httpBasic(Customizer.withDefaults())
            .build()
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {

        return BCryptPasswordEncoder()

    }

}