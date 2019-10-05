package com.antyzero.ticket.core

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import com.antyzero.ticket.core.utils.genericOfInterface
import com.antyzero.ticket.core.validator.TicketValidator
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

class TicketCheck(
    private val repository: Repository,
    validators: Collection<TicketValidator<*>>,
    init: Collection<Init> = emptySet()
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

    init {
        init.forEach { it.invoke(this) }
    }

    @Suppress("UNCHECKED_CAST")
    suspend fun <T : Ticket.Data> addTicket(ticket: Ticket<T>): Ticket<*> {
        val dataType = ticket.dataType() as KClass<in Ticket.Data>
        val validatorDataClass = ticketValidators.keys.firstOrNull {
            dataType.isSubclassOf(it)
        }
        val ticketValidator: TicketValidator<T> =
            (ticketValidators[validatorDataClass] as? TicketValidator<T>)
                ?: throw IllegalStateException("Given ticket with data type $dataType is not supported")
        val status = ticketValidator.isValid(ticket) ?: Ticket.Status.Invalid
        // TODO it might be good idea to notify about validation

        val verifiedTicket = ticket.copy(status = status)

        repository.addTicket(verifiedTicket)

        return verifiedTicket
    }

    suspend fun tickets(): Collection<Ticket<*>> {
        return repository.all()
    }

    private suspend fun <T : Ticket.Data> validate(ticket: Ticket<T>): Ticket.Status? {
        @Suppress("UNCHECKED_CAST")
        return (ticketValidators.values.first() as TicketValidator<T>).isValid(ticket)
    }

    interface Init : (TicketCheck) -> Unit
}
