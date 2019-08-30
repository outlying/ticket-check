package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.model.Ticket

object DumbRepository : Repository {

    override fun addTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override fun updateTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override fun removeTicket(ticket: Ticket<*>) {
        // do nothing
    }

    override fun all(): Collection<Ticket<*>> = emptyList()
}