package com.dave.fish.domain.posts

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class PostsRepositoryTest{

    @Autowired
    lateinit var postsRepository: PostsRepository

    @After
    fun cleanup(){
        /**
         * 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
         **/
        postsRepository.deleteAll()
    }

    @Test
    fun 게시글저장_불러오기(){
        // given
        val now = LocalDateTime.now()
        postsRepository.save(Posts(
                title = "테스트 게시글",
                content = "테스트 본문",
                author = "developerkhy@gmail.com"))

        // when
        val postsList: List<Posts> = postsRepository.findAll()

        // then
        val posts = postsList[0]
        assertThat(posts.title, `is`("테스트 게시글"))
        assertThat(posts.content, `is`("테스트 본문"))

        assertTrue(posts.createdDate.isAfter(now))
        assertTrue(posts.modifiedDate.isAfter(now))
    }
}
