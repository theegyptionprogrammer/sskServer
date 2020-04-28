package com.example.sskServer.modules

import javax.persistence.*

@Entity
class Team(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val teamId: Long,
        val listPlayer: List<Player>)