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
        val id: Int,
        @Column(name = "name")
        @ApiModelProperty(position = 2)
        val name: String,
        @Column(name = "position")
        @ApiModelProperty(position = 3)
        val position: String,
        @Column(name = "profilePicture")
        @ApiModelProperty(position = 4)
        val profilePicture: String,
        @Column(name = "contact")
        @ApiModelProperty(position = 6)
        val contact: Long,
        @Column(name = "institute")
        @ApiModelProperty(position = 7)
        val institute: String
)