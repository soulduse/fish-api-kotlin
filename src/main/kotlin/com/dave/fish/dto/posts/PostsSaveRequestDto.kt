package com.dave.fish.dto.posts

import com.dave.fish.domain.posts.Posts

class PostsSaveRequestDto{
    var title: String = ""
    var content: String = ""
    var author: String = ""

    fun toEntity(): Posts{
        return Posts(title = title, content = content, author = author)
    }
}
