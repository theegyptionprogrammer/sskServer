package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@Data
@NoArgsConstructor
@Table(name = "nationalPlayer")
class NationalPlayer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        @ApiModelProperty(position = 1)
        val nationalPlayerId: Int,
        @Column(name = "name")
        @ApiModelProperty(position = 2)
        val nationalPlayerName: String,
        @Column(name = "position")
        @ApiModelProperty(position = 3)
        val nationalPlayerPosition: String,
        @Column(name = "profilePicture")
        @ApiModelProperty(position = 4)
        val nationalPlayerPP: String,
        @Column(name = "link")
        @ApiModelProperty(position = 5)
        val nationalPlayerLink: Long,
        @Column(name = "achievements")
        @ApiModelProperty(position = 6)
        val nationalPlayerAchievement: String,
        @Column(name = "institute")
        @ApiModelProperty(position = 7)
        val nationalPlayerInstitute: String
)