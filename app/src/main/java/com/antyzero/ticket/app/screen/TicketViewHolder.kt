package com.antyzero.ticket.app.screen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antyzero.ticket.app.R

class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textViewId = itemView.findViewById<TextView>(R.id.textViewId)
    val textViewData = itemView.findViewById<TextView>(R.id.textViewData)
}