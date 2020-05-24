package com.example.sskServer.services

import com.example.sskServer.models.Organizer
import com.example.sskServer.repositories.OrganizerRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@RequiredArgsConstructor
class OrganizerServiceImpl : OrganizerService {

    @Autowired
    lateinit var organizerRepository: OrganizerRepository

    @Transactional
    override fun saveOrganizer(organizer: Organizer): Organizer {
        return organizerRepository.save(organizer)
    }

    @Transactional
    override fun getAllOrganizers(): MutableIterable<Organizer> {
        return organizerRepository.findAll()
    }

    @Transactional
    override fun deleteOrganizer(organizer: Organizer) {
        return organizerRepository.delete(organizer)
    }

    @Transactional
    override fun findOrganizerById(id: Long): Optional<Organizer> {
        return organizerRepository.findById(id)
    }

    @Transactional
    override fun findOrganizerByInstitute(institute: String): Optional<Organizer> {
        return organizerRepository.findByInstitute(institute)
    }

    override fun findOrganizerByName(name: String): Optional<Organizer> {
        return organizerRepository.findByName(name)
    }
}