package com.dave.fish.domain.posts

import com.dave.fish.domain.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * val 상수로 선언한 이유는 데이터 set을 막기 위함.
 */

@Entity
data class Posts(
        @Id
        @GeneratedValue
        val id: Long = -1,

        @Column(length = 500, nullable = false)
        val title: String,

        @Column(columnDefinition = "TEXT", nullable = false)
        val content: String,

        val author: String
): BaseTimeEntity()
