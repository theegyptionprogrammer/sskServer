package com.example.sskServer.controllers.nationalTeamController

import com.example.sskServer.modules.AchievementNT
import com.example.sskServer.modules.HistoryNT
import com.example.sskServer.modules.Match
import com.example.sskServer.repositores.AchievementRepository
import com.example.sskServer.repositores.HistoryRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class LegacyController {

    @Autowired
    lateinit var historyRepository: HistoryRepository
    @Autowired
    lateinit var achievementRepository: AchievementRepository

    // is it better to search video and link separately or to just upload history parameter?
    @GetMapping("/historyNT")
    fun getHistoryNT() = historyRepository.findAll()

    @GetMapping("/achievementsNT")
    fun getAchievementNT() = achievementRepository.findAll()

    @PostMapping("/historyNT")
    fun setHistoryNT(@RequestBody historyNT: HistoryNT) = historyRepository.save(historyNT)

    @PostMapping("/achievementNT")
    fun setHistoryNT(@RequestBody achievementsNT: AchievementNT)
            = achievementRepository.save(achievementsNT)

    @PutMapping("/historyNT/{id}")
    fun updateHistoryById(@PathVariable(value = "id") historyNtId: Long,
                        @Valid @RequestBody newHistoryNT: HistoryNT): ResponseEntity<HistoryNT> {

        return historyRepository.findById(historyNtId).map { existingHistory ->
            val updatedHistoryNT: HistoryNT = existingHistory
                    .copy(historyLink = newHistoryNT.historyLink, historyVideo = newHistoryNT.historyVideo,
                            historyNTId = newHistoryNT.historyNTId)
            ResponseEntity.ok().body(historyRepository.save(updatedHistoryNT))
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/achievementNT/{id}")
    fun updateAchievementById(@PathVariable(value = "id") achievementNtId: Long,
                        @Valid @RequestBody newAchievementNT: AchievementNT): ResponseEntity<AchievementNT> {

        return achievementRepository.findById(achievementNtId).map { existingAchievement ->
            val updatedAchievementNT: AchievementNT = existingAchievement
                    .copy(achievementId = newAchievementNT.achievementId, achievementText = newAchievementNT.achievementText)
            ResponseEntity.ok().body(achievementRepository.save(updatedAchievementNT))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/history{id}")
    fun deleteHistoryById(@PathVariable(value = "id") historyId: Long): ResponseEntity<Void> {
        return historyRepository.findById(historyId).map { History->
            historyRepository.delete(History)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/achievement{id}")
    fun deleteAchievementById(@PathVariable(value = "id") achievement: String): ResponseEntity<Void> {
        return achievementRepository.findById(achievement).map { Achievement->
            achievementRepository.delete(Achievement)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    /* handling errors */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)

}