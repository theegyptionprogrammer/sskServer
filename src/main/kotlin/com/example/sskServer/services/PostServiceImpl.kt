package com.example.sskServer.services

import com.example.sskServer.models.Post
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
    override fun addPost(post: Post): Post {
        return postRepository.save(post)
    }

    @Transactional
    override fun addListPosts(postList: List<Post>): MutableIterable<Post> {
        return postRepository.saveAll(postList)
    }

    @Transactional
    override fun getAllPosts(): MutableIterable<Post> {
        return postRepository.findAll()
    }

    @Transactional
    override fun searchPostById(id: Long): Optional<Post> {
        return postRepository.findById(id)
    }

    @Transactional
    override fun deletePost(post: Post) {
        return postRepository.delete(post)
    }

    @Transactional
    override fun updatePost(post: Post): Post {
        return postRepository.save(post)
    }
}