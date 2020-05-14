package com.example.sskServer.services

import com.example.sskServer.models.Player


interface PlayerService {
    fun addPlayer(player: Player): Player
    fun addPlayers(listPlayers: List<Player>): MutableIterable<Player>
    fun deletePlayer(player: Player)
    fun updatePlayer(player: Player): Player
    fun getAllPlayers(): MutableIterable<Player>
    //  fun getPlayerById(id: Long):Optional<Player>
    //  fun getPlayerByName(name: String):Optional<Player>
}