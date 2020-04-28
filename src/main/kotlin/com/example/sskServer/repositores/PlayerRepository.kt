package com.example.sskServer.repositores

import com.example.sskServer.modules.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// when i can use crud repository
@Repository
interface PlayerRepository: CrudRepository<Player, Long> {}

@Repository
interface PostRepository: CrudRepository<Post, Long> {}

@Repository
interface ResultMatchRepository: CrudRepository<ResultMatch, Long> {}

@Repository
interface ScheduleMatchRepository: CrudRepository<Match, Long> {}

@Repository
interface TeamRepository: CrudRepository<Team, Long> {}


