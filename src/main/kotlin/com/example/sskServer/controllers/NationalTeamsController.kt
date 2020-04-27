package com.example.sskServer.controllers

import com.example.sskServer.repositores.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class NationalTeamsController() {

    @Autowired
    lateinit var playerRepository: PlayerRepository
    @Autowired
    lateinit var postRepository: PostRepository
    @Autowired
    lateinit var resultMatchRepository: ResultMatchRepository
    @Autowired
    lateinit var scheduleMatchRepository: ScheduleMatchRepository
    @Autowired
    lateinit var teamRepository: TeamRepository

    @GetMapping("/getTeam")
    fun getTeam() = teamRepository.getTeam()

    @PostMapping("/setTeam")
    fun setTeam() = teamRepository.getTeam()

    @GetMapping("/getPlayerName")
    fun getPlayerName(@RequestParam playerName: String) = playerRepository.getPlayerName(playerName)

    @GetMapping("/getPlayerPosition")
    fun getPlayerPosition(@RequestParam playerPosition: String) = playerRepository.getPlayerPosition(playerPosition)

    @GetMapping("/getPlayerPP")
    fun getPlayerPP(@RequestParam playerPP: String) = playerRepository.getPlayerPP(playerPP)


// we are getting all the players direct or getting name, pp etc individually?
// when we use repository and when we use service?
}