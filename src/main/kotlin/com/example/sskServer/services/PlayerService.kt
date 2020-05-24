package com.example.sskServer.services

import com.example.sskServer.models.Player
import java.util.*


interface PlayerService {
    fun savePlayer(player: Player): Player
    fun savePlayers(listPlayers: List<Player>): MutableIterable<Player>
    fun getAllPlayers(): MutableIterable<Player>
    fun findPlayerById(id: Long): Optional<Player>
    fun findPlayerByName(name: String): Optional<Player>
    fun deletePlayer(player: Player)
}