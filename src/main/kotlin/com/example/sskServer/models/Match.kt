package com.example.sskServer.models

import javax.persistence.*

@Entity
@Table(name = "match")
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val matchId: Long,
        @Column(name = "matchTime")
        val matchTime: Long,
        @Column(name = "matchLocation")
        val matchLocation: String,
        @Column(name = "matchLogoHome")
        val matchLogoHome: String,
        @Column(name = "matchLogoAway")
        val matchLogoAway: String,
        @Column(name = "matchNameHome")
        val matchNameHome: String,
        @Column(name = "matchNameAway")
        val matchNameAway: String
)