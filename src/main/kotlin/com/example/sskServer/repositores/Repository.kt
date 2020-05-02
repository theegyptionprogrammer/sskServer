package com.example.sskServer.repositores

import com.example.sskServer.modules.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: CrudRepository<Player, Any> {
    fun searchPlayerByName(text: String): List<Player>
}

@Repository
interface PostRepository: CrudRepository<Post, Any> {
    fun searchByText(text: String): List<Post>
    fun searchByYear(year: Long): List<Post>
}

@Repository
interface ResultMatchRepository: CrudRepository<ResultMatch, Any> {}

@Repository
interface MatchRepository: CrudRepository<Match, Any> {}

@Repository
interface TeamRepository: CrudRepository<NationalTeam, Any> {}

@Repository
interface HistoryRepository: CrudRepository<HistoryNT, Any>

@Repository
interface AchievementRepository: CrudRepository<AchievementNT, Any>


