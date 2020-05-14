package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "Player")
data class Player(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "playerID")
        @ApiModelProperty(position = 1)
        val playerId: Int,
        @Column(name = "playerName")
        @ApiModelProperty(position = 2)
        val playerName: String,
        @Column(name = "playerPosition")
        @ApiModelProperty(position = 3)
        val playerPosition: String,
        @Column(name = "playerPP")
        @ApiModelProperty(position = 4)
        val playerPP: String)