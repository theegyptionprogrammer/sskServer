package com.example.sskServer.repositores

import com.example.sskServer.modules.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// when i can use crud repository
@Repository
interface PlayerRepository: CrudRepository<Player, Long> {
    fun getPlayerName(playerName: String): Iterable<Player>
    fun getPlayerPP(playerPP: String): Iterable<Player>
    fun getPlayerPosition(playerPosition: String): Iterable<Player>
}

@Repository
interface PostRepository: CrudRepository<Post, Long> {
    fun getPosts(): Iterable<List<Post>>
}

@Repository
interface ResultMatchRepository: CrudRepository<ResultMatch, Long> {
    fun getResultMatches(): Iterable<List<ResultMatch>>
}

@Repository
interface ScheduleMatchRepository: CrudRepository<Match, Long> {
    fun getScheduleMatches(): Iterable<List<Match>>
}

@Repository
interface TeamRepository: CrudRepository<Team, Long> {
    fun getTeam(): Iterable<List<Player>>
    fun setTeam(): Iterable<List<Player>>
    fun addTeam(): Iterable<List<Player>>
    fun removeTeam(): Iterable<List<Player>>
}


