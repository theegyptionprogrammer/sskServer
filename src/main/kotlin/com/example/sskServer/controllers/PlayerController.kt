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
@RequestMapping("/player")
class PlayerController {

    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping("/get")
    @ApiOperation(value = "View a list of all players", response = Player::class, responseContainer = "List")
    fun getAllPlayers(): Iterable<Player> = playerService.getAllPlayers()


    @PostMapping("/Save")
    @ApiOperation(value = "add a new player", response = Player::class)
    fun savePlayer(@RequestBody player: Player): ResponseEntity<*>? {
        return try {
            ResponseEntity(playerService.savePlayer(player), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete a new player", response = Player::class)
    fun deletePlayer(@RequestBody player: Player): ResponseEntity<*>? {
        return try {
            ResponseEntity(playerService.deletePlayer(player), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @RequestMapping("/{id}", method = [RequestMethod.GET])
    @ApiOperation(value = "search a player by id", response = Player::class)
    fun findById(@RequestParam(name = "playerId") playerId: Long): ResponseEntity<*>? {
        return try {
            val player: Optional<Player> = playerService.findPlayerById(playerId)
            if (player.isPresent) {
                ResponseEntity(player.get(), HttpStatus.OK)
            } else {
                noPlayerFoundResponseID(playerId)
            }
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @RequestMapping("/{name}")
    @ApiOperation(value = "search a player by name", response = Player::class)
    fun findByName(@RequestParam(name = "playerName") playerName: String): ResponseEntity<*>? {
        return try {
            val player: Optional<Player> = playerService.findPlayerByName(playerName)
            if (player.isPresent) {
                ResponseEntity(player.get(), HttpStatus.OK)
            } else {
                noPlayerFoundResponseName(playerName)
            }
        } catch (e: IllegalArgumentException) {
            return handleError(e)
        }
    }

    @PostMapping("/save")
    fun savePlayers(): String {
        playerService.savePlayer(Player(3, "koctya", "center", "nice", 2351235, "mgu"))
        playerService.savePlayer(Player(4, "kiro", "center", "nice", 2351235, "mirea"))
        playerService.savePlayer(Player(2, "danial", "center", "nice", 2351235, "mo"))
        playerService.savePlayer(Player(1, "shady", "center", "nice", 2351235, "asdf"))

        return "Customer are created"
    }

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