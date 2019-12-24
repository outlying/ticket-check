package com.antyzero.ticket.app.i18n

import android.content.Context
import com.antyzero.ticket.core.model.Ticket

object TicketDataStringers {

    private val map: MutableMap<Class<out Ticket.Data>, TicketDataStringer<*>> = mutableMapOf()

    private fun register(ticketDataStringer: TicketDataStringer<*>) {
        map[ticketDataStringer.getDataClass()] = ticketDataStringer
    }

    init {
        register(KKMDataStringer)
    }

    fun i18n(context: Context, data: Ticket.Data): CharSequence {

        val ticketDataStringer = (map.toList()
            .firstOrNull {
                it.first == data::class.java
            }?.second ?: default)

        @Suppress("UNCHECKED_CAST")
        return (ticketDataStringer as TicketDataStringer<Ticket.Data>).i18n(context, data)
    }

    private val default = object : TicketDataStringer<Ticket.Data> {

        override fun i18n(context: Context, data: Ticket.Data): CharSequence {
            return data.toString()
        }


        override fun getDataClass(): Class<out Ticket.Data> {
            throw IllegalAccessError("Not needed in default")
        }

    }
}