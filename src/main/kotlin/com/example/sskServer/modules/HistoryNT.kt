package com.example.sskServer.modules

import javax.persistence.*

@Entity
@Table(name = "HistoryNT")
data class HistoryNT (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val historyNTId: Long,
    @Column(name = "historyVideo")
    val historyVideo: String,
    @Column(name = "historyLink")
    val historyLink: Char
)