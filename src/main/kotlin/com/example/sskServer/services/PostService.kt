package com.example.sskServer.services

import com.example.sskServer.models.Post
import java.util.*

interface PostService {
    fun addPost(post: Post): Post
    fun addListPosts(postList: List<Post>): MutableIterable<Post>
    fun getAllPosts(): MutableIterable<Post>
    fun searchPostById(id: Long): Optional<Post>
    fun deletePost(post: Post)
    fun updatePost(post: Post): Post
}