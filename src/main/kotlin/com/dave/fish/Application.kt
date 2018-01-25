package com.dave.fish

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringWebserviceWithKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringWebserviceWithKotlinApplication::class.java, *args)
}
