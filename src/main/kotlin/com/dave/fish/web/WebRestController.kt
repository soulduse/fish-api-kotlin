package com.dave.fish.web

import com.dave.fish.dto.posts.PostsSaveRequestDto
import com.dave.fish.service.PostsService
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebRestController(var postsService: PostsService, var env: Environment) {

    @GetMapping("/hello")
    fun hello(): String = "Hello World!"

    @PostMapping("/posts")
    fun savePosts(@RequestBody dto: PostsSaveRequestDto): Long = postsService.save(dto)

    @GetMapping("/profile")
    fun getProfile(): String = env.activeProfiles.first() ?: ""
}
