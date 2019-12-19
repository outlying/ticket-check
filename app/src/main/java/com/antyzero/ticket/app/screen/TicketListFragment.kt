package com.antyzero.ticket.app.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.antyzero.ticket.app.R
import com.antyzero.ticket.app.access.ticketCheckUI
import com.antyzero.ticket.app.observe
import kotlinx.android.synthetic.main.fragment_ticket_list.*

class TicketListFragment : Fragment() {

    private val adapter = TicketAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ticket_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        ticketCheckUI.tickets(this).getTickets().observe(this) {
            adapter.submitList(it)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = TicketListFragment()
    }
}
