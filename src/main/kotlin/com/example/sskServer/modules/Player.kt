package com.example.sskServer.modules

import javax.persistence.*

@Entity
@Table(name = "player")
data class Player(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val playerId: Int,
        @Column(name = "playerName")
        val playerName: String,
        @Column(name = "playerPosition")
        val playerPosition: String,
        @Column(name = "playerPP")
        val playerPP: String)