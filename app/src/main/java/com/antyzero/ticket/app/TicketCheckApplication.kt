package com.antyzero.ticket.app

import android.app.Application
import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.repository.DumbRepository

class TicketCheckApplication : Application() {

    private val repository by lazy {
        DumbRepository
    }

    private val ticketCheck: TicketCheck by lazy {
        TicketCheck(
            repository,
            emptySet()
        )
    }
}