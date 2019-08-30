package com.antyzero.ticket.core.validator

import com.antyzero.ticket.core.model.Ticket

interface TicketValidator<T : Ticket.Data> {

    /**
     *
     * @return [Ticket.Status] if it was possible to figure out ticket status, null if something
     * went wrong
     */
    fun isValid(ticket: Ticket<T>): Ticket.Status?
}