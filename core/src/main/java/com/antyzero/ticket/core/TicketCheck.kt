package com.antyzero.ticket.core

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import com.antyzero.ticket.core.utils.genericOfInterface
import com.antyzero.ticket.core.validator.TicketValidator
import kotlin.reflect.KClass

class TicketCheck(
    private val repository: Repository,
    validators: Collection<TicketValidator<*>>
) {

    @Suppress("UNCHECKED_CAST")
    private val ticketValidators: Map<KClass<in Ticket.Data>, TicketValidator<*>> = validators
        .map {
            genericOfInterface(
                it,
                TicketValidator::class
            ).first().classifier as KClass<in Ticket.Data> to it
        }
        .toMap()

    fun addTicket(ticket: Ticket<*>): Ticket<*> {
        return ticket
    }

    fun tickets(): Collection<Ticket<*>> {
        return emptyList()
    }

    private fun <T : Ticket.Data> validate(ticket: Ticket<T>): Ticket.Status? {
        return (ticketValidators.values.first() as TicketValidator<T>).isValid(ticket)
    }
}
