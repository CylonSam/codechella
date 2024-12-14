package com.github.cylonsam.codechella.controller

import com.github.cylonsam.codechella.domain.Evento
import com.github.cylonsam.codechella.repository.EventoRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/eventos")
class EventoController(
    private val eventoRepository: EventoRepository,
) {

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun obterEventos(): Flux<Evento> {
        return eventoRepository.findAll()
    }
}