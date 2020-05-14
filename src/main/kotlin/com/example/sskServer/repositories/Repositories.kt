package com.example.sskServer.repositories

import com.example.sskServer.models.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PlayerRepository : CrudRepository<Player, Long> {
    //   fun searchPlayerByName(text: String): Optional<Player>
//    fun searchPlayerByID(id: Long): Optional<Player>
}

@Repository
interface PostRepository : CrudRepository<Post, Any>

@Repository
interface ResultMatchRepository : CrudRepository<ResultMatch, Any>

@Repository
interface MatchRepository : CrudRepository<Match, Any>

@Repository
interface TeamRepository : CrudRepository<NationalTeam, Any>

@Repository
interface HistoryRepository : CrudRepository<HistoryNT, Any>
