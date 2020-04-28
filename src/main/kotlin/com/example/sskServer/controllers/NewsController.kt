package com.example.server.controllers

import com.example.sskServer.modules.Post
import com.example.sskServer.repositores.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class NewsController() {

    @Autowired
    lateinit var postRepository: PostRepository

    @PostMapping("/posts")
    fun setPost(@RequestBody post: Post): Post = postRepository.save(post)

    @GetMapping("/posts")
    fun getPost(): Iterable<Post> = postRepository.findAll()

    @DeleteMapping("/posts{id}")
    fun deletePostById(@PathVariable(value = "id") postId: Long): ResponseEntity<Void> {
        return postRepository.findById(postId).map { article ->
            postRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/articles/{id}")
    fun updatePostById(@PathVariable(value = "id") postId: Long,
                          @Valid @RequestBody newPost: Post): ResponseEntity<Post> {

        return postRepository.findById(postId).map { existingPost ->
            val updatedPost: Post = existingPost
                    .copy(postText = newPost.postText, postPicture = newPost.postPicture)
            ResponseEntity.ok().body(postRepository.save(updatedPost))
        }.orElse(ResponseEntity.notFound().build())

    }
}