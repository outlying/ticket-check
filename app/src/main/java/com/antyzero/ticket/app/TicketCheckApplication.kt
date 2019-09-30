package com.antyzero.ticket.app

import android.app.Application
import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.json.JsonFileRepository
import com.antyzero.ticket.core.ui.TicketCheckUI

class TicketCheckApplication : Application() {

    private val repositoryFile = createTempFile("repository", ".json")

    private val repository by lazy {
        JsonFileRepository(repositoryFile).also {
            // it.addTicket(Ticket<String>("asd", status = Ticket.Status.Invalid, data = ""))
        }
    }

    private val ticketCheck: TicketCheck by lazy {
        TicketCheck(
            repository,
            emptySet()
        )
    }

    internal val ticketCheckUI: TicketCheckUI by lazy {
        TicketCheckUI(ticketCheck)
    }
}