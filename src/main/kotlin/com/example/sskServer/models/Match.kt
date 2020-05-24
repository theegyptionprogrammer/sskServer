package com.example.sskServer.models

import javax.persistence.*

@Entity
@Table(name = "match")
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "matchTime")
        val time: Long,
        @Column(name = "matchLocation")
        val location: String,
        @Column(name = "matchLogoHome")
        val logoHome: String,
        @Column(name = "matchLogoAway")
        val logoAway: String,
        @Column(name = "matchNameHome")
        val nameHome: String,
        @Column(name = "matchNameAway")
        val nameAway: String
)