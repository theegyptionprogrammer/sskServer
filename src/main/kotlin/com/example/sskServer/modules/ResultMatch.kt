package com.example.sskServer.modules

import javax.persistence.*

@Entity
data class ResultMatch(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val resultMatchId: Long,
        val scoreAway: Int,
        val scoreHome: Int,
        val resultMatchLogoHome: String,
        val resultMatchLogoAway: String,
        val resultMatchNameHome: String,
        val resultMatchNameAway: String
)