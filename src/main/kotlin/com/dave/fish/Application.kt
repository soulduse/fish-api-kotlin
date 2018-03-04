package com.dave.fish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
class Application

val APPLICATION_LOCATIONS = "spring.config.location=" +
        "classpath:application.yml," +
        "/app/config/springboot-webservice/real-application.yml"

fun main(args: Array<String>) {
    println("APPLICATION_LOCATIONS --> $APPLICATION_LOCATIONS")

    SpringApplicationBuilder(Application::class.java)
            .properties(APPLICATION_LOCATIONS)
            .run(*args)
}
