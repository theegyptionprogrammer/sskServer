package com.example.sskServer.services

import com.example.sskServer.models.Organizer
import java.util.*

interface OrganizerService {
    fun saveOrganizer(organizer: Organizer): Organizer
    fun getAllOrganizers(): MutableIterable<Organizer>
    fun findOrganizerById(id: Long): Optional<Organizer>
    fun findOrganizerByInstitute(institute: String): Optional<Organizer>
    fun findOrganizerByName(name: String): Optional<Organizer>
    fun deleteOrganizer(organizer: Organizer)
}