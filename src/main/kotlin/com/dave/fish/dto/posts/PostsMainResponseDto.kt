package com.dave.fish.dto.posts

import com.dave.fish.domain.posts.Posts
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class PostsMainResponseDto {

    var id: Long
    private set

    var title: String
    private set

    var author: String
    private set

    var modifiedDate: String
    private set

    constructor(entity: Posts){
        id = entity.id
        title = entity.title
        author = entity.author
        modifiedDate = toStringDateTimeByKotlin(entity.modifiedDate)
    }

    /**
     * Java 8 버전
     */
    private fun toStringDateTime(localDateTime: LocalDateTime?): String{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("")
    }

    /**
     * Java 7 버전
     */
    private fun toStringDateTimeByJava7(localDateTime: LocalDateTime?): String{
        if(localDateTime == null){
            return ""
        }

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return formatter.format(localDateTime)
    }

    /**
     * Kotlin 버전
     */
    private fun toStringDateTimeByKotlin(localDateTime: LocalDateTime?): String{
        return localDateTime?.let {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(it)
        } ?: ""
    }
}
