package com.example.sskServer.controllers.nationalTeamController

import com.example.sskServer.modules.Match
import com.example.sskServer.modules.Player
import com.example.sskServer.repositores.MatchRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class MatchController {

    @Autowired
    lateinit var matchRepository: MatchRepository

    @GetMapping("/getMatch")
    fun getMatches() = matchRepository.findAll()

    @PostMapping("/setMatch")
    fun setMatch(@RequestBody match: Match) = matchRepository.save(match)

    @DeleteMapping("/match{id}")
    fun deleteMatchById(@PathVariable(value = "id") matchId: Long): ResponseEntity<Void> {
        return matchRepository.findById(matchId).map { match->
            matchRepository.delete(match)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/updateMatch/{id}")
    fun updateMatchById(@PathVariable(value = "id") matchId: Long,
                         @Valid @RequestBody newMatch: Match): ResponseEntity<Match> {

        return matchRepository.findById(matchId).map { existingMatch ->
            val updatedMatch: Match = existingMatch
                    .copy(matchId = newMatch.matchId, matchLocation = newMatch.matchLocation, matchTime = newMatch.matchTime,
                            matchLogoAway = newMatch.matchLogoAway, matchLogoHome = newMatch.matchLogoHome,
                            matchNameAway = newMatch.matchNameAway, matchNameHome = newMatch.matchNameHome)
            ResponseEntity.ok().body(matchRepository.save(updatedMatch))
        }.orElse(ResponseEntity.notFound().build())
    }

    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)

}