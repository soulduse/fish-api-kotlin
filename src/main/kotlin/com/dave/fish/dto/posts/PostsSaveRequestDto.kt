package com.dave.fish.dto.posts

import com.dave.fish.domain.posts.Posts

/**
 * Nullable -> 초기값 설정 ex) var title: String = ""
 * NotNull -> 늦은 초기화 ex) lateinit var title: String
 *
 * lateinit로 선언된 경우, 값을 받지 못하면 에러가 발생한다.
 */

class PostsSaveRequestDto{
    lateinit var title: String
    lateinit var content: String
    lateinit var author: String

    fun toEntity(): Posts{
        return Posts(title = title, content = content, author = author)
    }
}
