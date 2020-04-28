package com.example.sskServer.modules

import javax.persistence.*

@Entity
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val matchId: Long,
        val matchTime: Long,
        val matchLocation: String,
        val matchLogoHome: String,
        val matchLogoAway: String,
        val matchNameHome: String,
        val matchNameAway: String
)