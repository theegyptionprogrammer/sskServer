package com.example.server.controllers

import com.example.sskServer.repositores.PostRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class SportClubController(){

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)
}