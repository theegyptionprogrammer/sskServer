package com.example.sskServer.modules

import javax.persistence.*

@Entity
data class Player(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val playerId: Int,
        val playerName: String,
        val playerPosition: String,
        val playerPP: String)