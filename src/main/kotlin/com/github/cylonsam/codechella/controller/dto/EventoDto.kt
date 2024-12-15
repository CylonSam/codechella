package com.github.cylonsam.codechella.controller.dto

import com.github.cylonsam.codechella.domain.Evento
import com.github.cylonsam.codechella.domain.TipoEvento
import java.time.LocalDate

data class EventoDto(
    val id: Long,
    val tipo: TipoEvento,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
)

fun toEventDto(evento: Evento): EventoDto =
    EventoDto(
        evento.id,
        evento.tipo,
        evento.nome,
        evento.data,
        evento.descricao,
    )
