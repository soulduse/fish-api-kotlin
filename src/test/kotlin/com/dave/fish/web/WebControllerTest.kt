package com.dave.fish.web

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebControllerTest {
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun 메인페이지_로딩(){
        // when
        val body = this.restTemplate.getForObject("/", String::class.java)

        // then
        assertThat(body).contains("스프링부트로 시작하는 웹 서비스")
    }

    @Test
    fun 메인페이지_데이터_읽기(){
        val body = this.restTemplate.getForObject("/", String::class.java)

        assertThat(body).contains("test2@gmail.com")
    }
}
