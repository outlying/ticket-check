package com.antyzero.ticket.app.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antyzero.ticket.app.R

class TicketListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ticket_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = TicketListFragment()
    }
}
