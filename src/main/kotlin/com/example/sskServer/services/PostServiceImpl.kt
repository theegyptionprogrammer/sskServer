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
    override fun findPostById(id: String): Optional<Post> {
        return postRepository.findById(id)
    }

    override fun findPostByText(text: String): Optional<Post> {
        return postRepository.findPostByText(text)
    }

    override fun findPostByTimePublishing(timePublishing: Long): Optional<Post> {
        return postRepository.findPostByTimePublishing(timePublishing)
    }

    @Transactional
    override fun deletePost(post: Post) {
        return postRepository.delete(post)
    }
}