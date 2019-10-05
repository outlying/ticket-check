package com.antyzero.ticket.app

import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.provider.kkm.KKMData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.math.BigInteger

object BuildTypeInit : TicketCheck.Init {

    override fun invoke(ticketCheck: TicketCheck) {
        GlobalScope.launch {
            ticketCheck.addTicket(
                Ticket(
                    id = "2170708",
                    data = KKMData.Normal(
                        cardNumber = BigInteger.valueOf(20603546690)
                    ),
                    status = Ticket.Status.Invalid
                )
            )
        }
    }
}