package com.dave.fish.domain.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.stream.Stream


interface PostsRepository: JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    fun findAllDesc(): Stream<Posts>
}
