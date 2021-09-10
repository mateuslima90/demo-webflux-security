package io.mkth.demowebfluxsecurity.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class SecurityController {

    @GetMapping("/")
    fun getString(): Mono<String> {
        return Mono.just("Testando")
    }
}