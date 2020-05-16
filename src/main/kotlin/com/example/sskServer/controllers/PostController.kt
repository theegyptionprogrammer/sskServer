package com.example.sskServer.controllers

import com.example.sskServer.models.Post
import com.example.sskServer.services.PostService
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequiredArgsConstructor
class PostController {

    @Autowired
    lateinit var postService: PostService

    @PostMapping("/post/add")
    @ApiOperation(value = "add a new post", response = Post::class)
    fun addPost(@RequestBody post: Post): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.addPost(post), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/post/getall")
    @ApiOperation(value = "get all posts", response = Post::class)
    fun getAllPosts(): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.getAllPosts(), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/post/delete")
    @ApiOperation(value = "delete a new post", response = Post::class)
    fun deletePost(@RequestBody post: Post): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.deletePost(post), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/post/search/{id}")
    @ApiOperation(value = "search a post", response = Post::class)
    fun searchPostById(@RequestParam(name = "postId") postId: Long): ResponseEntity<*>? {
        return try {
            val post = postService.searchPostById(postId)
            if (post.isPresent) {
                ResponseEntity(postService.searchPostById(postId), HttpStatus.OK)
            } else {
                noPostFoundResponseID(postId)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException) = ResponseEntity("Try server later", HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseID(id: Long) = ResponseEntity("No post found with id: $id", HttpStatus.NOT_FOUND)
}