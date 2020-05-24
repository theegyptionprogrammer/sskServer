package com.example.sskServer.services

import com.example.sskServer.models.Player
import com.example.sskServer.repositories.PlayerRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
@RequiredArgsConstructor
class PlayerServiceImpl : PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Transactional
    override fun savePlayer(player: Player): Player {
        return playerRepository.save(player)
    }

    @Transactional
    override fun savePlayers(listPlayers: List<Player>): MutableIterable<Player> {
        return playerRepository.saveAll(listPlayers)
    }

    @Transactional
    override fun deletePlayer(player: Player) {
        return playerRepository.delete(player)
    }

    @Transactional
    override fun getAllPlayers(): MutableIterable<Player> {
        return playerRepository.findAll()
    }


    @Transactional
    override fun findPlayerById(id: Long): Optional<Player> {
        return playerRepository.findById(id)
    }

    @Transactional
    override fun findPlayerByName(name: String): Optional<Player> {
        return playerRepository.findPlayerByName(name)
    }

}