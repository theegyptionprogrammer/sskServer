package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@Table(name = "player")
data class Player(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        @ApiModelProperty(position = 1)
        val playerId: Int,
        @Column(name = "playerName")
        @ApiModelProperty(position = 2)
        val playerName: String,
        @Column(name = "position")
        @ApiModelProperty(position = 3)
        val playerPosition: String,
        @Column(name = "profilePicture")
        @ApiModelProperty(position = 4)
        val playerPP: String,
        @Column(name = "contact")
        @ApiModelProperty(position = 6)
        val playerContact: Long,
        @Column(name = "institute")
        @ApiModelProperty(position = 7)
        val playerInstitute: String
)