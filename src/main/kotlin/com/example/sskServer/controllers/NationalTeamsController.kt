package com.example.sskServer.controllers

import com.example.sskServer.modules.Player
import com.example.sskServer.modules.Team
import com.example.sskServer.repositores.*
import com.sun.net.httpserver.Authenticator
import com.sun.net.httpserver.Authenticator.Success
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @GetMapping("/team")
    fun getTeam() = teamRepository.findAll()

    @GetMapping("/player")
    fun getPlayer() = playerRepository.findAll()

    @PostMapping("/team")
    fun setTeam(@RequestBody team: Team): Team = teamRepository.save(team)

    @PostMapping("player")
    fun setPlayer(@RequestBody player: Player) = playerRepository.save(player)

    @DeleteMapping("/posts{id}")
    fun deleteTeamById(@PathVariable(value = "id") teamId: Long): ResponseEntity<Void> {
        return teamRepository.findById(teamId).map { team ->
            teamRepository.delete(team)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/posts{id}")
    fun deletePlayerById(@PathVariable(value = "id") playerId: Long): ResponseEntity<Void> {
        return playerRepository.findById(playerId).map { player ->
            playerRepository.delete(player)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }


}