package com.example.sskServer.controllers

import com.example.sskServer.models.Player
import com.example.sskServer.services.PlayerService
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequiredArgsConstructor
class PlayerController {

    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping("/players/get")
    @ApiOperation(value = "View a list of all players", response = Player::class, responseContainer = "List")
    fun getAllPlayers(): Iterable<Player> = playerService.getAllPlayers()


    @PostMapping("/player/save")
    @ApiOperation(value = "add a new player", response = Player::class)
    fun addPlayer(@RequestBody player: Player): ResponseEntity<*>? {
        return try {
            ResponseEntity(playerService.addPlayer(player), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @PostMapping("/player/delete")
    @ApiOperation(value = "delete a new player", response = Player::class)
    fun deletePlayer(@RequestBody player: Player): ResponseEntity<*>? {
        return try {
            ResponseEntity(playerService.deletePlayer(player), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @PostMapping("/player/search/{id}")
    @ApiOperation(value = "search a player", response = Player::class)
    fun searchPlayer(@RequestParam(name = "playerId") playerId: Long): ResponseEntity<*>? {
        return try {
            val player: Optional<Player> = playerService.searchPlayerById(playerId)
            if (player.isPresent) {
                ResponseEntity(playerService.searchPlayerById(playerId), HttpStatus.OK)
            } else {
                noPlayerFoundResponseID(playerId)
            }
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @GetMapping("/players/save")
    fun savePlayers(): String {
        val player1: Player = Player(1, "kiro", "center", "nice", 12314123)
        val player2: Player = Player(2, "sasha", "center", "nice", 5251352)
        val player3: Player = Player(3, "koctya", "center", "nice", 2351235)
        val listPlayers: List<Player> = listOf(player1, player2, player3)
        playerService.addPlayers(listPlayers)
        return "players have been added"
    }
/*

    @GetMapping("/players/search/{name}")
    @ApiOperation(value = "search a player by name", response = Player::class)
    fun searchPlayerByName(@PathVariable(value = "playerName") playerName: String): ResponseEntity<*>?{
        return try {
            val player: Optional<Iterator<List<Player>>> = playerService.getPlayerByName(playerName)
            if (player.isPresent){
                ResponseEntity(playerService.getPlayerByName(playerName), HttpStatus.OK)
            } else {
                noPlayerFoundResponseName(playerName)
            }
        } catch (e: IllegalArgumentException){
            handleError(e)
        }
    }
*/


    /*

    @PutMapping("/update/player/{id}")
    @ApiOperation(value = "update player info", response = Player::class)
    fun updateTask(@PathVariable(value = "id") playerId: Long): ResponseEntity<*>? {
        return try{
            val getPlayer: Optional<Player> = playerService.getPlayerById(playerId)
            if (getPlayer.isPresent){
                playerService.updatePlayer(getPlayer.get())
                ResponseEntity(String.format("Player with id: %d was updated", playerId), HttpStatus.OK )
            } else {
                return noPlayerFoundResponse(playerId)
            }
        } catch (e: Exception){
            return errorResponse()
        }
    }


*/
    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException) = ResponseEntity("error, try server later", HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPlayerFoundResponseID(id: Long) = ResponseEntity("No player found with id: $id", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPlayerFoundResponseName(name: String) = ResponseEntity("No player found with name: $name", HttpStatus.NOT_FOUND)


}