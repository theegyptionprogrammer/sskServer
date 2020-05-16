package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@Data
@NoArgsConstructor
@Table(name = "post")
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(position = 1)
        val postId: Long,
        @Column(name = "postTitle")
        @ApiModelProperty(position = 2)
        val postTitle: String,
        @Column(name = "postText")
        @ApiModelProperty(position = 3)
        val postText: String,
        @Column(name = "postPicture")
        @ApiModelProperty(position = 4)
        val postPicture: String,
        @Column(name = "postTimePublish")
        @ApiModelProperty(position = 5)
        val postTimePublish: Long)

