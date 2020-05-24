package com.example.sskServer.services

import com.example.sskServer.models.Post
import java.util.*

interface PostService {
    fun savePost(post: Post): Post
    fun saveListPosts(postList: List<Post>): MutableIterable<Post>
    fun getAllPosts(): MutableIterable<Post>
    fun findPostById(id: String): Optional<Post>
    fun findPostByText(text: String): Optional<Post>
    fun findPostByTimePublishing(timePublishing: Long): Optional<Post>
    fun deletePost(post: Post)
}