package com.example.sskServer.services

import com.example.sskServer.models.Post
import java.util.*

interface PostService {
    fun savePost(post: Post): Post
    fun saveListPosts(postList: List<Post>): MutableIterable<Post>
    fun getAllPosts(): MutableIterable<Post>
    fun findById(id: Long): Optional<Post>
    fun findByTimePublishing(timePublishing: Long): Optional<Post>
    fun findByHashTag(hashTag: Char): Optional<Post>
    fun searchPostByText(text: String): Optional<Post>
    fun deletePost(post: Post)
}