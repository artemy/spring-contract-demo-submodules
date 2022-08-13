package com.github.artemy.springcloudcontractdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<DemoApplication>(*args)
}
