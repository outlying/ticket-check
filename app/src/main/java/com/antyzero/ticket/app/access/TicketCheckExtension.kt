package com.antyzero.ticket.app.access

import android.content.Context
import androidx.fragment.app.Fragment
import com.antyzero.ticket.app.TicketCheckApplication
import com.antyzero.ticket.core.ui.TicketCheckUI


private val Context.ticketCheckApplication: TicketCheckApplication
    get() = this.applicationContext as TicketCheckApplication

val Context.ticketCheckUI: TicketCheckUI
    get() = ticketCheckApplication.ticketCheckUI

val Fragment.ticketCheckUI: TicketCheckUI
    get() = if (isAdded) {
        context?.ticketCheckUI
            ?: throw IllegalStateException("Fragment is not attached to Activity")
    } else {
        throw IllegalStateException("Fragment is not attached to Activity")
    }