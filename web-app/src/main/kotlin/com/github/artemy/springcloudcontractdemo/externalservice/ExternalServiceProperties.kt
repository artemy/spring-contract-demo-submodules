package com.github.artemy.springcloudcontractdemo.externalservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("external-service")
data class ExternalServiceProperties(
    val url: String
)
