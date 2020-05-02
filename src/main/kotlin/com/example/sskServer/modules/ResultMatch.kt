package com.example.sskServer.modules

import javax.persistence.*

@Entity
@Table(name = "resultMatch")
data class ResultMatch(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val resultMatchId: Long,
        @Column(name = "scoreAway")
        val scoreAway: Int,
        @Column(name = "scoreHome")
        val scoreHome: Int,
        @Column(name = "resultMatchLogoHome")
        val resultMatchLogoHome: String,
        @Column(name = "resultMatchLogoAway")
        val resultMatchLogoAway: String,
        @Column(name = "resultMatchNameHome")
        val resultMatchNameHome: String,
        @Column(name = "resultMatchNameAway")
        val resultMatchNameAway: String)