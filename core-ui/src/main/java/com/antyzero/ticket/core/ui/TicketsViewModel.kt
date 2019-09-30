package com.antyzero.ticket.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.model.Ticket

class TicketsViewModel(ticketCheck: TicketCheck) : ViewModel() {

    private val tickets:MutableLiveData<List<Ticket<*>>> by lazy {
        MutableLiveData<List<Ticket<*>>>().also {
            loadTickets()
        }
    }

    fun getTickets(): LiveData<List<Ticket<*>>> = tickets

    private fun loadTickets() {

    }

}