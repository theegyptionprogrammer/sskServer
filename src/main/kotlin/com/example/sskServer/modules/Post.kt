package com.example.sskServer.modules

import javax.persistence.*


@Entity
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val postId: Long,
        val postText: String,
        val postPicture: String)

