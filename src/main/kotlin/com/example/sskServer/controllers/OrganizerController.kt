package com.example.sskServer.controllers

import com.example.sskServer.models.Organizer
import com.example.sskServer.services.OrganizerService
import io.swagger.annotations.ApiOperation
import lombok.NoArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@NoArgsConstructor
class OrganizerController {

    @Autowired
    lateinit var organizerService: OrganizerService

    @PostMapping("/organizer/add")
    @ApiOperation(value = "add a new organizer", response = Organizer::class)
    fun saveOrganizer(@RequestBody organizer: Organizer): ResponseEntity<*>? {
        return try {
            ResponseEntity(organizerService.saveOrganizer(organizer), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/getall")
    @ApiOperation(value = "get all organizers", response = Organizer::class)
    fun getAllOrganizers(): ResponseEntity<*>? {
        return try {
            ResponseEntity(organizerService.getAllOrganizers(), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/delete")
    @ApiOperation(value = "delete an organizer", response = Organizer::class)
    fun deleteOrganizer(@RequestBody organizer: Organizer): ResponseEntity<*>? {
        return try {
            ResponseEntity(organizerService.deleteOrganizer(organizer), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/search/{id}")
    @ApiOperation(value = "find an organizer", response = Organizer::class)
    fun findById(@RequestParam(name = "organizerId") organizerId: Long): ResponseEntity<*>? {
        return try {
            val organizer = organizerService.findOrganizerById(organizerId)
            if (organizer.isPresent) {
                ResponseEntity(organizerService.findOrganizerById(organizerId), HttpStatus.OK)
            } else {
                noPostFoundResponseID(organizerId)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/search/{id}")
    @ApiOperation(value = "find an organizer", response = Organizer::class)
    fun findByName(@RequestParam(name = "organizerName") organizerName: String): ResponseEntity<*>? {
        return try {
            val organizer = organizerService.findOrganizerByName(organizerName)
            if (organizer.isPresent) {
                ResponseEntity(organizerService.findOrganizerByName(organizerName), HttpStatus.OK)
            } else {
                noPostFoundResponseName(organizerName)
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
    fun noPostFoundResponseID(id: Long) = ResponseEntity("No organizer found with id: $id", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseName(name: String) = ResponseEntity("No organizer found with id: $name", HttpStatus.NOT_FOUND)
}