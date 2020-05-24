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
        val id: Long,
        @Column(name = "title")
        @ApiModelProperty(position = 2)
        val title: String,
        @Column(name = "text")
        @ApiModelProperty(position = 3)
        val text: String,
        @Column(name = "picture")
        @ApiModelProperty(position = 4)
        val picture: String,
        @Column(name = "timePublishing")
        @ApiModelProperty(position = 5)
        val timePublishing: Long,
        @Column(name = "hashTag")
        @ApiModelProperty(position = 6)
        val hashTag: Char
)

