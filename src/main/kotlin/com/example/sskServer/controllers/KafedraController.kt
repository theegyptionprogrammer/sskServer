package com.example.server.controllers

import com.example.sskServer.repositores.ScheduleMatchRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class KafedraController(val scheduleMatchRepository: ScheduleMatchRepository){
 //   @ExceptionHandler(IllegalArgumentException::class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    fun handleError(e: IllegalArgumentException): DefaultResponse? = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)
}