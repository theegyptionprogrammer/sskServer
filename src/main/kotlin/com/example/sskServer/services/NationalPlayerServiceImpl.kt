package com.example.sskServer.services


import com.example.sskServer.models.NationalPlayer
import com.example.sskServer.repositories.NationalPlayerRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@RequiredArgsConstructor
class NationalPlayerServiceImpl : NationalPlayerService {

    @Autowired
    lateinit var nationalPlayerRepository: NationalPlayerRepository

    @Transactional
    override fun saveNationalPlayer(nationalPlayer: NationalPlayer): NationalPlayer {
        return nationalPlayerRepository.save(nationalPlayer)
    }

    @Transactional
    override fun getAllNationalPlayers(): MutableIterable<NationalPlayer> {
        return nationalPlayerRepository.findAll()
    }

    @Transactional
    override fun deleteNationalPlayer(nationalPlayer: NationalPlayer) {
        return nationalPlayerRepository.delete(nationalPlayer)
    }

    @Transactional
    override fun findNationalPlayerById(id: Long): Optional<NationalPlayer> {
        return nationalPlayerRepository.findById(id)
    }

    @Transactional
    override fun findNationalPlayerByName(name: String): Optional<NationalPlayer> {
        return nationalPlayerRepository.findByName(name)
    }
}

