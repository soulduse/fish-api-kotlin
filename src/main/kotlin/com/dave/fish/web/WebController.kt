package com.dave.fish.web

import com.dave.fish.service.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController(var postsService: PostsService) {

    @GetMapping("/")
    fun main(model: Model): String{
        model.addAttribute("posts", postsService.findAllDesc())
        return "main"
    }
}
