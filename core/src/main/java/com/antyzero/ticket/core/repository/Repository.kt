package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.model.Ticket

interface Repository {

    fun addTicket(ticket: Ticket<*>)

    fun updateTicket(ticket: Ticket<*>)

    fun removeTicket(ticket: Ticket<*>)

    fun all(): Collection<Ticket<*>>
}