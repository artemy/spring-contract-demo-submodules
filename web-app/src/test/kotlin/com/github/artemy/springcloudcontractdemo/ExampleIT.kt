package com.github.artemy.springcloudcontractdemo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.context.ApplicationContext
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient


@ActiveProfiles("test")
@AutoConfigureStubRunner(ids = ["com.github.artemy:contracts:+:stubs"])
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ExampleIT {

    @Autowired
    private lateinit var context: ApplicationContext

    private lateinit var testClient: WebTestClient

    @BeforeEach
    fun setup() {
        testClient = WebTestClient.bindToApplicationContext(context)
            .build()
    }

    @Test
    fun exampleTest() {
        testClient.get()
            .uri("/api")
            .accept(APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .is2xxSuccessful
    }
}
