package com.example.sskServer.services


import com.example.sskServer.models.NationalPlayer
import java.util.*

interface NationalPlayerService {
    fun saveNationalPlayer(nationalPlayer: NationalPlayer): NationalPlayer
    fun getAllNationalPlayers(): MutableIterable<NationalPlayer>
    fun findNationalPlayerById(id: Long): Optional<NationalPlayer>
    fun findNationalPlayerByName(name: String): Optional<NationalPlayer>
    fun deleteNationalPlayer(nationalPlayer: NationalPlayer)
}


