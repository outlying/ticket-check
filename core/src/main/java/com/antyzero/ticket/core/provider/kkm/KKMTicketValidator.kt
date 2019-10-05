package com.antyzero.ticket.core.provider.kkm

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.validator.TicketValidator

class KKMTicketValidator : TicketValidator<KKMData> {

    override suspend fun isValid(ticket: Ticket<KKMData>): Ticket.Status? {
        return null
    }
}