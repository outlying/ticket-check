package com.antyzero.ticket.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antyzero.ticket.core.TicketCheck

class LocalViewModelFactory(private val ticketCheck: TicketCheck) : ViewModelProvider.Factory {

    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return when (modelClass) {
            TicketsViewModel::class.java -> TicketsViewModel(ticketCheck)
            else -> IllegalArgumentException("Unsupported class type $modelClass")
        } as T
    }
}