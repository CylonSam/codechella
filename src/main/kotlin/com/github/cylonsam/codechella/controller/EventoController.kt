package com.github.cylonsam.codechella.controller

import com.github.cylonsam.codechella.controller.dto.EventoDto
import com.github.cylonsam.codechella.controller.dto.toDto
import com.github.cylonsam.codechella.service.EventoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/eventos")
class EventoController(
    private val eventoService: EventoService,
) {
    @PostMapping
    fun createEvent(
        @RequestBody payload: EventoDto,
    ): Mono<EventoDto> = eventoService.createEvent(payload.toEntity()).map { toDto(it) }

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEvents(): Flux<EventoDto> = eventoService.getEventos().map { toDto(it) }

    @GetMapping("/{id}")
    fun getEventById(
        @PathVariable id: Long,
    ): Mono<EventoDto> =
        eventoService
            .getEventoById(id)
            .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND)))
            .map { toDto(it) }

    @PutMapping("/{id}")
    fun updateEventById(
        @PathVariable id: Long,
        @RequestBody payload: EventoDto,
    ): Mono<EventoDto> = eventoService.updateEventById(id, payload.toEntity()).map { toDto(it) }

    @DeleteMapping("/{id}")
    fun deleteEventById(
        @PathVariable id: Long,
    ): Mono<Void> = eventoService.deleteEventById(id)
}
