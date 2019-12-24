package com.antyzero.ticket.app.i18n

import android.content.Context
import com.antyzero.ticket.core.model.Ticket

interface TicketDataStringer<T> where T : Ticket.Data {

    fun i18n(context: Context, data: T): CharSequence

    fun getDataClass(): Class<out T>
}