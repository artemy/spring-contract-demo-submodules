package com.github.artemy.springcloudcontractdemo

import com.github.artemy.springcloudcontractdemo.externalservice.ExternalServiceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class AppConfiguration(private val externalServiceProperties: ExternalServiceProperties) {

    @Bean
    fun externalWebClient() =
        WebClient.builder()
            .baseUrl(externalServiceProperties.url)
            .build()
}
