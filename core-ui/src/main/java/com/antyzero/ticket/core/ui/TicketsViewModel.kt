package com.antyzero.ticket.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antyzero.ticket.core.TicketCheck
import com.antyzero.ticket.core.model.Ticket
import kotlinx.coroutines.launch

class TicketsViewModel(private val ticketCheck: TicketCheck) : ViewModel() {

    private val tickets: MutableLiveData<List<Ticket<*>>> by lazy {
        MutableLiveData<List<Ticket<*>>>().also {
            loadTickets()
        }
    }

    fun getTickets(): LiveData<List<Ticket<*>>> = tickets

    private fun loadTickets() {
        viewModelScope.launch {
            tickets.postValue(ticketCheck.tickets().toList())
        }
    }
}