package com.dave.fish.service

import com.dave.fish.domain.posts.PostsRepository
import com.dave.fish.dto.posts.PostsMainResponseDto
import com.dave.fish.dto.posts.PostsSaveRequestDto
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.assertj.core.api.Assertions.assertThat


@RunWith(SpringRunner::class)
@SpringBootTest
class PostServiceTest {

    @Autowired
    lateinit var postsService: PostsService

    @Autowired
    lateinit var postsRepository: PostsRepository

    @After
    fun cleanup(){
        postsRepository.deleteAll()
    }

    @Test
    fun Dto데이터가_posts테이블에_저장된다(){
        // given
        val dto = PostsSaveRequestDto().apply {
            title = "테스트 타이틀"
            content = "테스트 컨텐트"
            author = "developerkhy@gmail.com"
        }

        postsService.save(dto)

        val post = postsRepository.findAll().first()

        assertThat(post.title == dto.title)
        assertThat(post.content == dto.content)
        assertThat(post.author == dto.author)
    }

    @Test
    fun 저장된_데이터를_읽어온다(){
        // given
        val post = postsService.findAllDesc().first()

        assertThat(post.title == "테스트1")
        assertThat(post.author == "test1@gmail.com")
    }
}
