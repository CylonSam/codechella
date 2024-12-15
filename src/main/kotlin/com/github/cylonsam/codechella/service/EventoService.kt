package com.github.cylonsam.codechella.service

import com.github.cylonsam.codechella.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
) {
    fun getEventos() = eventoRepository.findAll()

    fun getEventoById(id: Long) = eventoRepository.findById(id)
}
