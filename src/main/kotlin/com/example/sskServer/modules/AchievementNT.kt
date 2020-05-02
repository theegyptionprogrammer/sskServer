package com.example.sskServer.modules

import javax.persistence.*

@Entity
@Table(name = "achievements")
data class AchievementNT (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val achievementId: Long,
        @Column(name = "achievementText")
        val achievementText: String
)