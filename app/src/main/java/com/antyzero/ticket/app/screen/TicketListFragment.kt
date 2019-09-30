package com.antyzero.ticket.app.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antyzero.ticket.app.R
import com.antyzero.ticket.app.access.ticketCheckUI
import com.antyzero.ticket.app.observe

class TicketListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ticket_list, container, false)
    }

    override fun onResume() {
        super.onResume()

        ticketCheckUI.tickets(this).getTickets().observe(this) {
            it.forEach { ticket ->
                println(ticket)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = TicketListFragment()
    }
}
