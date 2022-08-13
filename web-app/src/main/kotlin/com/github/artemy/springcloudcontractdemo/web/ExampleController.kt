package com.github.artemy.springcloudcontractdemo.web

import com.github.artemy.springcloudcontractdemo.FooResponse
import com.github.artemy.springcloudcontractdemo.externalservice.ExternalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class ExampleController(private val externalService: ExternalService) {

    @GetMapping
    fun exampleEndpoint(): Mono<FooResponse> =
        externalService.call()
}
