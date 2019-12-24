package com.antyzero.ticket.app.i18n

import android.content.Context
import com.antyzero.ticket.core.model.Ticket.Data

abstract class BaseTicketDataStringer<T>(private val clazz: Class<T>) : TicketDataStringer<T> where T : Data {

    override fun i18n(context: Context, data: T): CharSequence {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataClass(): Class<out T> = clazz
}