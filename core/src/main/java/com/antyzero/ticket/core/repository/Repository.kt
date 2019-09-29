package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.model.Ticket

interface Repository {

    suspend fun addTicket(ticket: Ticket<*>)

    suspend fun updateTicket(ticket: Ticket<*>)

    suspend fun removeTicket(ticket: Ticket<*>): Boolean

    suspend fun all(): Collection<Ticket<*>>
}