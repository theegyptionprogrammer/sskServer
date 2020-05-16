package com.example.sskServer.repositories

import com.example.sskServer.models.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : CrudRepository<Player, Long> {
    //   fun searchPlayerByID(playerID: Long): Optional<Iterator<Player>>
    // fun searchPlayerByName(playerName: String): Optional<Iterator<List<Player>>>
}

@Repository
interface PostRepository : CrudRepository<Post, Any>

@Repository
interface NationalPlayerRepository : CrudRepository<NationalPlayer, Any>

@Repository
interface OrganizerRepository : CrudRepository<Organizer, Any>

@Repository
interface ResultMatchRepository : CrudRepository<ResultMatch, Any>

@Repository
interface MatchRepository : CrudRepository<Match, Any>

@Repository
interface TeamRepository : CrudRepository<NationalTeam, Any>

@Repository
interface HistoryRepository : CrudRepository<HistoryNT, Any>
