package com.example.sskServer.models

import javax.persistence.*

@Entity
@Table(name = "NationalTeam")
data class NationalTeam(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val nationalTeamId: Long,
        @Column(name = "nationalTeamLogo")
        val nationalTeamLogo: String,
        @Column(name = "nationalTeamName")
        val nationalTeamName: String,
        @Column(name = "nationalTeamVkLink")
        val nationalTeamVkLink: Char,
        @Column(name = "nationalTeamInstaLink")
        val nationalTeamInstaLink: Char
)
