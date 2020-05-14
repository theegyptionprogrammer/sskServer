package com.example.sskServer.controllers

import com.example.sskServer.models.Player
import com.example.sskServer.services.PlayerService
import com.example.sskServer.utils.DefaultResponse
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class StaffController {

    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping("/players/get")
    @ApiOperation(value = "View a list of all players", response = Player::class, responseContainer = "List")
    fun getAllPlayers(): Iterable<Player> = playerService.getAllPlayers()


    @PostMapping("/player/save")
    @ApiOperation(value = "add a new player", response = Player::class)
    fun addPlayer(@RequestBody player: Player): ResponseEntity<*>? {
        return try {
            ResponseEntity<Any?>(
                    playerService.addPlayer(player),
                    HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return errorResponse()
        }
    }

    @GetMapping("/player/save")
    fun savePlayer(): String {
        val player: Player = Player(1, "kiro", "center", "nice")
        playerService.addPlayer(player)
        return "player is added"
    }

    @GetMapping("/players/save")
    fun savePlayers(): String {
        val player1: Player = Player(1, "kiro", "center", "nice")
        val player2: Player = Player(2, "sasha", "center", "nice")
        val player3: Player = Player(3, "koctya", "center", "nice")
        val listPlayers: List<Player> = listOf(player1, player2, player3)
        playerService.addPlayers(listPlayers)
        return "players have been added"
    }


    /*
    @DeleteMapping("/delete/player/{id}")
    @ApiOperation(value = "delete player by id", response = Player::class)
    fun deletePlayerById(@PathVariable(value = "id") playerId: Long): ResponseEntity<*>? {
        return try {
            val getPlayer: Optional<Player> = playerService.getPlayerById(playerId)
            if(getPlayer.isPresent){
                playerService.deletePlayer(getPlayer.get())
                ResponseEntity(String.format("Player with id: %d was deleted", playerId), HttpStatus.OK)
            } else {
                 return noPlayerFoundResponse(playerId)
            }
        } catch (e: Exception){
            return errorResponse()
        }
    }

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

/*    @GetMapping("/search/player/{id}")
    @ApiOperation(value = "search player by id", response = Player::class)
    fun searchPlayerById(@PathVariable(value = "id") playerId: Long): ResponseEntity<*>? {
        return try{
            val getPlayer: Optional<Player> = playerService.getPlayerById(playerId)
            if (getPlayer.isPresent){
                ResponseEntity(getPlayer.get(), HttpStatus.OK)
            } else {
                return noPlayerFoundResponse(playerId)
            }
        } catch (e: Exception){
            return errorResponse()
        }
    }
    */
/*
    @GetMapping("/search/player/{name}")
    @ApiOperation(value = "search player by name", response = Player::class)
    fun searchPlayerByName(@RequestParam playerName: String): ResponseEntity<*>? {
        return try {
            val getPlayer: Optional<Player> = playerService.getPlayerByName(playerName)
            if (getPlayer.isPresent){
                ResponseEntity(getPlayer.get(), HttpStatus.OK)
            } else {
                return ResponseEntity("No player found with a title: $playerName", HttpStatus.NOT_FOUND)
            }
        } catch (e: Exception){
            return errorResponse()
        }
    }
*/
*/
    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse.Error = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)

    private fun noPlayerFoundResponse(id: Long): ResponseEntity<String?>? {
        return ResponseEntity("No player found with id: $id", HttpStatus.NOT_FOUND)
    }

    private fun errorResponse(): ResponseEntity<String?>? {
        return ResponseEntity("Something went wrong :(", HttpStatus.INTERNAL_SERVER_ERROR)
    }

}