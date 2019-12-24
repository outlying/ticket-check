package com.antyzero.ticket.app.extension

import android.content.Context
import androidx.recyclerview.widget.RecyclerView


val RecyclerView.ViewHolder.context: Context
    get() = this.itemView.context