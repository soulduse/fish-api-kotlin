package com.dave.fish.service

import com.dave.fish.domain.posts.PostsRepository
import com.dave.fish.dto.posts.PostsMainResponseDto
import com.dave.fish.dto.posts.PostsSaveRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class PostsService(var postsRepository: PostsRepository) {

    @Transactional
    fun save(dto: PostsSaveRequestDto): Long{
        return postsRepository.save(dto.toEntity()).id
    }

    @Transactional(readOnly = true)
    fun findAllDesc(): List<PostsMainResponseDto>{
        return postsRepository.findAllDesc()
                .map{PostsMainResponseDto(it)}
                .toList()
    }
}
