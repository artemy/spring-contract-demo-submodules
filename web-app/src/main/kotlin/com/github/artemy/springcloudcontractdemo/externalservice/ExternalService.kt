package com.github.artemy.springcloudcontractdemo.externalservice

import com.github.artemy.springcloudcontractdemo.FooResponse
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
@EnableConfigurationProperties(ExternalServiceProperties::class)
class ExternalService(private val externalWebClient: WebClient) {
    fun call(): Mono<FooResponse> =
        externalWebClient.get()
            .uri("/foo")
            .accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToMono()
}
