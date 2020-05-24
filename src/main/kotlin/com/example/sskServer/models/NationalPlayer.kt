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
        @Column(name = "link")
        @ApiModelProperty(position = 5)
        val link: Long,
        @Column(name = "achievements")
        @ApiModelProperty(position = 6)
        val achievement: String,
        @Column(name = "institute")
        @ApiModelProperty(position = 7)
        val institute: String
)
