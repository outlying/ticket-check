package com.antyzero.ticket.core.model

import org.threeten.bp.LocalDate

data class Ticket<T : Ticket.Data>(
    val id: Any,
    val status: Status,
    val data: T
) {

    abstract class Data

    internal fun dataType() = data::class

    open class Status {

        /**
         * Indicated that ticket is valid and till when
         */
        data class Valid(val until: LocalDate) : Status()

        object Invalid : Status()
    }

    override fun toString(): String {
        return "Ticket(id=$id, status=$status, data=$data)"
    }
}