package com.github.cylonsam.codechella.repository

import com.github.cylonsam.codechella.domain.Evento
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface EventoRepository : ReactiveCrudRepository<Evento, Long>