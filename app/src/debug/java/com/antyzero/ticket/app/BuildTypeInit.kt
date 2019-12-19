package com.antyzero.ticket.app

import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.provider.kkm.KKMData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * This [TicketCheck.Init] implementation is used to provide initial setup for app in debug type
 */
object BuildTypeInit : TicketCheck.Init {

    override fun invoke(ticketCheck: TicketCheck) {
        GlobalScope.launch {
            ticketCheck.addTicket(
                Ticket(
                    id = "2170708",
                    data = KKMData.Normal(
                        cardNumber = 20603546690L
                    ),
                    status = Ticket.Status.Invalid
                )
            )
        }
    }
}