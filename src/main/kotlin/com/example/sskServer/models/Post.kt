package com.example.sskServer.models

import javax.persistence.*


@Entity
@Table(name = "post")
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val postId: Long,
        @Column(name = "postTitle")
        val postTitle: String,
        @Column(name = "postText")
        val postText: String,
        @Column(name = "postPicture")
        val postPicture: String,
        @Column(name = "postTimePublish")
        val postTimePublish: Long)

