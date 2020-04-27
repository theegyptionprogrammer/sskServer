package com.example.sskServer.modules

import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "post")
open class Post(val postId: Int, val postText: String, val postPicture: String)

