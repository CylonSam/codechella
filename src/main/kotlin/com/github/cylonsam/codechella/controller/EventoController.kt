package com.github.cylonsam.codechella.controller

import com.github.cylonsam.codechella.controller.dto.EventoDto
import com.github.cylonsam.codechella.controller.dto.toEventDto
import com.github.cylonsam.codechella.service.EventoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/eventos")
class EventoController(
    private val eventoService: EventoService,
) {
    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEventos(): Flux<EventoDto> = eventoService.getEventos().map { toEventDto(it) }

    @GetMapping("/{id}")
    fun getEventoById(
        @PathVariable id: Long,
    ): Mono<EventoDto> =
        eventoService
            .getEventoById(id)
            .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND)))
            .map { toEventDto(it) }
}
