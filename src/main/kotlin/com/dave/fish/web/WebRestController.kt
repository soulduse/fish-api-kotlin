package com.dave.fish.web

import com.dave.fish.dto.posts.PostsSaveRequestDto
import com.dave.fish.service.PostsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebRestController(var postsService: PostsService) {

    @GetMapping("/hello")
    fun hello(): String{
        return "Hello World!"
    }

    @PostMapping("/posts")
    fun savePosts(@RequestBody dto: PostsSaveRequestDto): Long{
        return postsService.save(dto)
    }
}
