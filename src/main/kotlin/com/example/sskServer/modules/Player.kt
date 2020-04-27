package com.example.sskServer.modules

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "player")
class Player(val playerName: String, val playerPosition: String, val playerId: Int, val playerPP: String)