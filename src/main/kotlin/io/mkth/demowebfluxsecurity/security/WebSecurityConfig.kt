package io.mkth.demowebfluxsecurity.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class WebSecurityConfig {
    
    @Bean
    fun securitygWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        return http.authorizeExchange()
                .pathMatchers("/")
                //.hasAuthority("ROLE_ADMIN")
                .permitAll()
                .anyExchange()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .csrf()
                .disable()
                .build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService? {
        val user: UserDetails = User
                .withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build()
        return MapReactiveUserDetailsService(user)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
