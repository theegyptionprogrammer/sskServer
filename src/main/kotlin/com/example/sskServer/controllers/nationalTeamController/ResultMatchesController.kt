package com.example.sskServer.controllers.nationalTeamController

import com.example.sskServer.modules.Player
import com.example.sskServer.modules.ResultMatch
import com.example.sskServer.repositores.ResultMatchRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ResultMatchesController {

    @Autowired
    lateinit var resultMatchRepository: ResultMatchRepository

    @GetMapping("/getResultsMatches")
    fun getResultMatches() = resultMatchRepository.findAll()

    @PostMapping("/setResultsMatches")
    fun setResultMatche(@RequestBody resultMatch: ResultMatch) = resultMatchRepository.save(resultMatch)

    @DeleteMapping("/player{id}")
    fun deleteResultMatchById(@PathVariable(value = "id") resultMatchId: Long): ResponseEntity<Void> {
        return resultMatchRepository.findById(resultMatchId).map { resultMatch ->
            resultMatchRepository.delete(resultMatch)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/updateResultMatch/{id}")
    fun updateResultMatchById(@PathVariable(value = "id") resultMatchId: Long,
                         @Valid @RequestBody newResultMatch: ResultMatch): ResponseEntity<ResultMatch> {

        return resultMatchRepository.findById(resultMatchId).map { existingResultMatch ->
            val updatedResultMatch: ResultMatch = existingResultMatch
                    .copy(resultMatchId = newResultMatch.resultMatchId, resultMatchLogoAway = newResultMatch.resultMatchLogoAway,
                            resultMatchLogoHome = newResultMatch.resultMatchLogoHome, resultMatchNameAway = newResultMatch.resultMatchNameAway,
                            resultMatchNameHome = newResultMatch.resultMatchNameHome, scoreAway = newResultMatch.scoreAway,
                            scoreHome = newResultMatch.scoreHome)
            ResponseEntity.ok().body(resultMatchRepository.save(updatedResultMatch))
        }.orElse(ResponseEntity.notFound().build())
    }

    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)

}