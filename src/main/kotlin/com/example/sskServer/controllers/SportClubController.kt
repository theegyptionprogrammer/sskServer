package com.example.server.controllers

import com.example.sskServer.repositores.PostRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class SportClubController(val postRepository: PostRepository)