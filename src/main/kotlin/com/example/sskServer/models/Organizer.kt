package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@Table(name = "organizer")
class Organizer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        @ApiModelProperty(position = 1)
        val organizerId: Long,
        @Column(name = "profilePicture")
        @ApiModelProperty(position = 2)
        val organizerPP: String,
        @Column(name = "name")
        @ApiModelProperty(position = 3)
        val organizerName: String,
        @Column(name = "contact")
        @ApiModelProperty(position = 4)
        val organizerContact: Long,
        @Column(name = "link")
        @ApiModelProperty(position = 5)
        val organizerLink: String,
        @Column(name = "role")
        @ApiModelProperty(position = 6)
        val organizerRole: String,
        @Column(name = "institute")
        @ApiModelProperty(position = 7)
        val organizerInstitute: String
)