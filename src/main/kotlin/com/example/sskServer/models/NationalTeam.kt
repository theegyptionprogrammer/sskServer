package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import javax.persistence.*

@Entity
@Table(name = "nationalTeam")
data class NationalTeam(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(position = 1)
        val nationalTeamId: Long,
        @Column(name = "logo")
        @ApiModelProperty(position = 2)
        val nationalTeamLogo: String,
        @Column(name = "name")
        @ApiModelProperty(position = 3)
        val nationalTeamName: String,
        @Column(name = "vkLink")
        @ApiModelProperty(position = 4)
        val nationalTeamVkLink: Char,
        @Column(name = "instaLink")
        @ApiModelProperty(position = 5)
        val nationalTeamInstaLink: Char
)
