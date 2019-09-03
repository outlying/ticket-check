package com.antyzero.ticket.app.access

import android.content.Context
import com.antyzero.ticket.app.TicketCheckApplication
import com.antyzero.ticket.core.TicketCheck


private val Context.ticketCheckApplication: TicketCheckApplication
    get() = this as TicketCheckApplication

val Context.ticketCheck: TicketCheck
    get() = ticketCheckApplication.ticketCheck