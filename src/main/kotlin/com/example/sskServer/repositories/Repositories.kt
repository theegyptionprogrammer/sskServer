package com.example.sskServer.repositories

import com.example.sskServer.models.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface PlayerRepository : CrudRepository<Player, Long> {
    fun findPlayerByName(name: String): Optional<Player>
}

@Repository
interface PostRepository : CrudRepository<Post, Any> {
    fun findPostByText(text: String): Optional<Post>
    fun findPostByTimePublishing(timePublishing: Long): Optional<Post>
}

@Repository
interface NationalPlayerRepository : CrudRepository<NationalPlayer, Any> {
    fun findNationalPlayerByName(name: String): Optional<NationalPlayer>
}

@Repository
interface FileRepository : CrudRepository<File, Any>

@Repository
interface OrganizerRepository : CrudRepository<Organizer, Any> {
    fun findOrganizerByInstitute(institute: String): Optional<Organizer>
    fun findOrganizerByName(name: String): Optional<Organizer>
}

@Repository
interface ResultMatchRepository : CrudRepository<ResultMatch, Any>

@Repository
interface MatchRepository : CrudRepository<Match, Any>

@Repository
interface TeamRepository : CrudRepository<NationalTeam, Any>

@Repository
interface HistoryRepository : CrudRepository<HistoryNT, Any>
