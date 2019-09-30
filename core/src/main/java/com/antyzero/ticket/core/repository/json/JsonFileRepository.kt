package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import com.antyzero.ticket.core.repository.json.model.JsonTicket
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import kotlinx.coroutines.Deferred
import java.io.File


class JsonFileRepository(private val file: File) : Repository {

    private var ongoingFileSave: Deferred<Unit>? = null
    private val tickets: MutableSet<Ticket<*>>
    private val adapter = createAdapter()

    init {
        if (file.exists()) {
            val readText = file.readText()

            if (readText.isBlank()) {
                tickets = mutableSetOf()
                dumpCurrentListToFile()
            } else {
                tickets = adapter.fromJson(readText)?.toSet()?.toMutableSet()
                    ?: throw IllegalStateException("Stuff went wrong")
            }
        } else {
            if (!file.createNewFile()) {
                throw IllegalStateException("Unable to create file")
            }
            tickets = mutableSetOf()
            dumpCurrentListToFile()
        }
    }

    override suspend fun addTicket(ticket: Ticket<*>) {
        tickets.add(ticket)
        dumpCurrentListToFile()
    }

    override suspend fun updateTicket(ticket: Ticket<*>) {
        if (tickets.removeAll { it.id == ticket.id }) {
            tickets.add(ticket)
            dumpCurrentListToFile()
        }
    }

    override suspend fun removeTicket(ticket: Ticket<*>): Boolean {
        val result = tickets.removeAll { it.id == ticket.id }
        dumpCurrentListToFile()
        return result
    }

    override suspend fun all(): Collection<Ticket<*>> {
        return tickets
    }

    private fun dumpCurrentListToFile() {
        file.writeText(adapter.toJson(tickets.toList()))
    }

    override fun toString(): String {
        return "JsonFileRepository(file=$file, tickets=$tickets)"
    }

    companion object {

        fun createAdapter(): JsonAdapter<List<Ticket<*>>> {

            val moshi = Moshi.Builder().apply {
                add(JsonTicket::class.java, TicketAdapter)
            }.build()

            return moshi.adapter(
                newParameterizedType(
                    List::class.java,
                    JsonTicket::class.java
                )
            )
        }
    }
}