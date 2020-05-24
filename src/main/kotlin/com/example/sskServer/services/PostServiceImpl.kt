package com.example.sskServer.services

import  com.example.sskServer.models.Post
import com.example.sskServer.repositories.PostRepository
import lombok.NoArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@NoArgsConstructor
class PostServiceImpl : PostService {

    @Autowired
    lateinit var postRepository: PostRepository

    @Transactional
    override fun savePost(post: Post): Post {
        return postRepository.save(post)
    }

    @Transactional
    override fun saveListPosts(postList: List<Post>): MutableIterable<Post> {
        return postRepository.saveAll(postList)
    }

    @Transactional
    override fun getAllPosts(): MutableIterable<Post> {
        return postRepository.findAll()
    }

    @Transactional
    override fun findById(id: Long): Optional<Post> {
        return postRepository.findById(id)
    }

    @Transactional
    override fun searchPostByText(text: String): Optional<Post> {
        return postRepository.findByText(text)
    }

    @Transactional
    override fun findByTimePublishing(timePublishing: Long): Optional<Post> {
        return postRepository.findByTimePublishing(timePublishing)
    }

    @Transactional
    override fun findByHashTag(hashTag: Char): Optional<Post> {
        return postRepository.findByHashTag(hashTag)
    }

    @Transactional
    override fun deletePost(post: Post) {
        return postRepository.delete(post)
    }
}