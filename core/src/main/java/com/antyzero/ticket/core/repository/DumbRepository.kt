package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.model.Ticket

object DumbRepository : Repository {

    override suspend fun addTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override suspend fun updateTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override suspend fun removeTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override suspend fun all(): Collection<Ticket<*>> = emptyList()
}