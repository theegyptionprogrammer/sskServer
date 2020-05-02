package com.example.sskServer.controllers.nationalTeamController

import com.example.sskServer.modules.Player
import com.example.sskServer.modules.Post
import com.example.sskServer.repositores.PlayerRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class StaffController {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @GetMapping("/getPlayer")
    fun getPlayers() = playerRepository.findAll()

    @PostMapping("setPlayer")
    fun setPlayer(@RequestBody player: Player): Player = playerRepository.save(player)

    @DeleteMapping("/player{id}")
    fun deletePlayerById(@PathVariable(value = "id") playerId: Long): ResponseEntity<Void> {
        return playerRepository.findById(playerId).map { player ->
            playerRepository.delete(player)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/updatePlayer/{id}")
    fun updatePlayerById(@PathVariable(value = "id") postId: Long,
                       @Valid @RequestBody newPlayer: Player): ResponseEntity<Player> {

        return playerRepository.findById(postId).map { existingPlayer ->
            val updatedPlayer: Player = existingPlayer
                    .copy(playerName = newPlayer.playerName, playerPP = newPlayer.playerPP,
                          playerPosition = newPlayer.playerPosition, playerId = newPlayer.playerId)
            ResponseEntity.ok().body(playerRepository.save(updatedPlayer))
        }.orElse(ResponseEntity.notFound().build())
    }

    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)

}