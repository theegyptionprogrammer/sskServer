package com.example.sskServer.repositories

import com.example.sskServer.models.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface PlayerRepository : CrudRepository<Player, Long> {
    fun findByName(name: String): Optional<Player>
}

@Repository
interface PostRepository : CrudRepository<Post, Long> {
    fun findByText(text: String): Optional<Post>
    fun findByTimePublishing(timePublishing: Long): Optional<Post>
    fun findByHashTag(hashTag: Char): Optional<Post>
}

@Repository
interface NationalPlayerRepository : CrudRepository<NationalPlayer, Any> {
    fun findByName(name: String): Optional<NationalPlayer>
}

@Repository
interface OrganizerRepository : CrudRepository<Organizer, Any> {
    fun findByInstitute(institute: String): Optional<Organizer>
    fun findByName(name: String): Optional<Organizer>
}

@Repository
interface ResultMatchRepository : CrudRepository<ResultMatch, Any>

@Repository
interface MatchRepository : CrudRepository<Match, Any>

/*
@Repository
interface TeamRepository : CrudRepository<NationalTeam, Any>

@Repository
interface HistoryRepository : CrudRepository<HistoryNT, Any>
*/