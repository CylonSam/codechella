package com.github.cylonsam.codechella.controller

import com.github.cylonsam.codechella.controller.dto.EventoDto
import com.github.cylonsam.codechella.controller.dto.toDto
import com.github.cylonsam.codechella.service.EventoService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/eventos")
class EventoController(
    private val eventoService: EventoService,
) {

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEventos(): Flux<EventoDto> {
        return eventoService.getEventos().map { toDto(it) }
    }
}