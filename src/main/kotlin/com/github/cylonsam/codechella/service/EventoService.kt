package com.github.cylonsam.codechella.service

import com.github.cylonsam.codechella.domain.Evento
import com.github.cylonsam.codechella.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
) {
    fun getEventos() = eventoRepository.findAll()

    fun getEventoById(id: Long) = eventoRepository.findById(id)

    fun createEvent(evento: Evento) = eventoRepository.save(evento)

    fun deleteEventById(id: Long) = eventoRepository.findById(id).flatMap { eventoRepository.delete(it) }

    fun updateEventById(
        id: Long,
        updatedEvent: Evento,
    ) = eventoRepository.findById(id).flatMap {
        eventoRepository.save(updatedEvent.copy(id = it.id))
    }
}
