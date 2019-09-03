package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import java.io.File

class JsonFileRepository(private val file: File) : Repository {

    private val tickets: MutableSet<Ticket<*>> = mutableSetOf()

    override suspend fun addTicket(ticket: Ticket<*>) {
        tickets.add(ticket)
        dumpCurrentListToFile()
    }

    override suspend fun updateTicket(ticket: Ticket<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun removeTicket(ticket: Ticket<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun all(): Collection<Ticket<*>> {
        // TODO read file
        return tickets
    }

    private fun dumpCurrentListToFile(){

    }
}