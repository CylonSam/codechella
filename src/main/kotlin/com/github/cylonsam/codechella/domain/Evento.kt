package com.github.cylonsam.codechella.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("eventos")
data class Evento(
    @Id
    val id: Long,
    val tipo: TipoEvento,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
)

enum class TipoEvento {
    SHOW,
    CONCERTO,
    TEATRO,
    PALESTRA,
    WORKSHOP,
}
