package io.mkth.demowebfluxsecurity.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

//@EnableWebFluxSecurity
//@Configuration
//class WebSecurityConfig {
//
//    @Bean
//    fun configure(http: HttpSecurity) {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//}
//}

@Configuration
@EnableWebFlux
@EnableWebFluxSecurity
class KotlinSecurityConfiguration : WebFluxConfigurer {

    @Bean
    fun configureSecurity(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .authorizeExchange()
                .pathMatchers("/").permitAll()
                .anyExchange().authenticated()
                .build()

    }

}