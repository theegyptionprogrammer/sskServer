package com.example.sskServer.controllers

import com.example.sskServer.models.NationalPlayer
import com.example.sskServer.services.NationalPlayerService
import io.swagger.annotations.ApiOperation
import lombok.NoArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@NoArgsConstructor
class NationalPlayerController {

    @Autowired
    lateinit var nationalPlayerService: NationalPlayerService

    @PostMapping("/nationalPlayer/add")
    @ApiOperation(value = "add a new nationalPlayer", response = NationalPlayer::class)
    fun addNationalPlayer(@RequestBody nationalPlayer: NationalPlayer): ResponseEntity<*>? {
        return try {
            ResponseEntity(nationalPlayerService.addNationalPlayer(nationalPlayer), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/nationalPlayer/getall")
    @ApiOperation(value = "get all national players", response = NationalPlayer::class)
    fun getAllNationalPlayers(): ResponseEntity<*>? {
        return try {
            ResponseEntity(nationalPlayerService.getAllNationalPlayers(), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/nationalPlayer/delete")
    @ApiOperation(value = "delete a national player", response = NationalPlayer::class)
    fun deleteNationalPlayer(@RequestBody nationalPlayer: NationalPlayer): ResponseEntity<*>? {
        return try {
            ResponseEntity(nationalPlayerService.deleteNationalPlayer(nationalPlayer), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/nationalPlayer/search/{id}")
    @ApiOperation(value = "search a nationalPlayer", response = NationalPlayer::class)
    fun searchNationalPlayerById(@RequestParam(name = "nationalPlayerId") nationalPlayerId: Long): ResponseEntity<*>? {
        return try {
            val nationalPlayer = nationalPlayerService.searchNationalPlayerById(nationalPlayerId)
            if (nationalPlayer.isPresent) {
                ResponseEntity(nationalPlayerService.searchNationalPlayerById(nationalPlayerId), HttpStatus.OK)
            } else {
                noPostFoundResponseID(nationalPlayerId)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException) = ResponseEntity("Try server later", HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseID(id: Long) = ResponseEntity("No national player found with id: $id", HttpStatus.NOT_FOUND)
}