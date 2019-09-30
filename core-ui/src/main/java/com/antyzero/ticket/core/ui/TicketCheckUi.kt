package com.antyzero.ticket.core.ui

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.antyzero.ticket.core.TicketCheck

class TicketCheckUi(ticketCheck: TicketCheck) {

    private val localViewModelFactory = LocalViewModelFactory(ticketCheck)

    fun tickets(activity: FragmentActivity) = ViewModelProviders
        .of(activity, localViewModelFactory)
        .get(TicketsViewModel::class.java)
}