package com.example.sskServer.models

import javax.persistence.*

@Entity
@Table(name = "resultMatch")
data class ResultMatch(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val matchId: Long,
        @Column(name = "scoreAway")
        val scoreAway: Int,
        @Column(name = "scoreHome")
        val scoreHome: Int,
        @Column(name = "logoHome")
        val logoHome: String,
        @Column(name = "logoAway")
        val logoAway: String,
        @Column(name = "nameHome")
        val nameHome: String,
        @Column(name = "nameAway")
        val nameAway: String)