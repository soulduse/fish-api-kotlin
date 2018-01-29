package com.dave.fish.domain.posts

import com.dave.fish.domain.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * private set : 외부 클래스에서 set을 막기 위함.
 */

@Entity
class Posts: BaseTimeEntity{
    @Id
    @GeneratedValue
    var id: Long = 0L

    @Column(length = 500, nullable = false)
    var title: String

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String

    var author: String

    constructor(title:String, content: String, author: String){
        this.title = title
        this.content = content
        this.author = author
    }
}
