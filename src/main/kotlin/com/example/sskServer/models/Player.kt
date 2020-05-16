package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@Table(name = "Player")
data class Player(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        @ApiModelProperty(position = 1)
        val playerId: Int,
        @Column(name = "name")
        @ApiModelProperty(position = 2)
        val playerName: String,
        @Column(name = "position")
        @ApiModelProperty(position = 3)
        val playerPosition: String,
        @Column(name = "profile picture")
        @ApiModelProperty(position = 4)
        val playerPP: String,
        @Column(name = "contact")
        @ApiModelProperty(position = 6)
        val playerContact: Long
)