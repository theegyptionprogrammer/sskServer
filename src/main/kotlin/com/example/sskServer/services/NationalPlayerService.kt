package com.example.sskServer.services

import com.example.sskServer.models.NationalPlayer
import java.util.*

interface NationalPlayerService {
    fun addNationalPlayer(nationalPlayer: NationalPlayer): NationalPlayer
    fun getAllNationalPlayers(): MutableIterable<NationalPlayer>
    fun deleteNationalPlayer(nationalPlayer: NationalPlayer)
    fun searchNationalPlayerById(id: Long): Optional<NationalPlayer>
}