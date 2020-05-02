package com.example.sskServer.controllers.nationalTeamController

import com.example.sskServer.modules.*
import com.example.sskServer.repositores.*
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class NationalTeamsController() {

    @Autowired
    lateinit var nationalTeamRepository: TeamRepository

    @GetMapping("/getTeam")
    fun getTeam() = nationalTeamRepository.findAll()

    @PostMapping("/setTeam")
    fun setTeam(@RequestBody nationalTeam: NationalTeam): NationalTeam = nationalTeamRepository.save(nationalTeam)

    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)
}