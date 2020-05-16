package com.example.sskServer.services

import com.example.sskServer.models.Organizer
import java.util.*

interface OrganizerService {
    fun addOrganizer(organizer: Organizer): Organizer
    fun getAllOrganizers(): MutableIterable<Organizer>
    fun deleteOrganizer(organizer: Organizer)
    fun searchOrganizerById(id: Long): Optional<Organizer>
    fun updateOrganizer(organizer: Organizer): Organizer
}