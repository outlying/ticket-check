package com.antyzero.ticket.app.screen

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.antyzero.ticket.app.R
import com.antyzero.ticket.app.extension.context
import com.antyzero.ticket.app.i18n.TicketDataStringers
import com.antyzero.ticket.core.model.Ticket

class TicketAdapter : ListAdapter<Ticket<*>, TicketViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(
            View.inflate(parent.context, R.layout.item_ticket, null)
        )
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        with(getItem(position)) {
            holder.textViewId.text = id
            holder.textViewData.text = data.convertToReadableGoogoo(holder.context)
        }
    }

    private fun Ticket.Data.convertToReadableGoogoo(context: Context): CharSequence {
        return TicketDataStringers.i18n(context, this)
    }

    companion object {

        private val diff = object : DiffUtil.ItemCallback<Ticket<*>>() {

            override fun areItemsTheSame(oldItem: Ticket<*>, newItem: Ticket<*>): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Ticket<*>, newItem: Ticket<*>): Boolean {
                return oldItem == newItem
            }
        }
    }
}