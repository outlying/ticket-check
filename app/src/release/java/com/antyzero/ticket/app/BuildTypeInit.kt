package com.antyzero.ticket.app

import com.antyzero.ticket.core.TicketCheck

object BuildTypeInit : TicketCheck.Init {

    override fun invoke(ticketCheck: TicketCheck) {
        // Release init, do nothing here
    }
}