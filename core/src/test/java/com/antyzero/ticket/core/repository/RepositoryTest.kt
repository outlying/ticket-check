package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.utils.createRepository
import com.antyzero.ticket.core.utils.createTicket
import com.antyzero.ticket.core.utils.tmpFile
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDate

internal class RepositoryTest {

    @Test
    fun `ticket saved correctly`() {
        val repository = createRepository()
        val ticket = createTicket()

        runBlocking { repository.addTicket(ticket) }

        val all = runBlocking { repository.all() }
        assertThat(all).contains(ticket)
    }

    @Test
    internal fun `preserve ticket for new repository instance`() = tmpFile { file ->
        val ticket = createTicket(status = Ticket.Status.Valid(until = LocalDate.MAX))
        runBlocking { createRepository(file).addTicket(ticket) }

        val allTickets = runBlocking { createRepository(file).all() }

        assertThat(allTickets).contains(ticket)
    }

    @Test
    fun updateTicket() {
    }

    @Test
    fun removeTicket() = tmpFile { file ->
        val ticket = createTicket().also { runBlocking { createRepository(file).addTicket(it) } }
        val secondRepository = createRepository(file)

        val result = runBlocking { secondRepository.removeTicket(ticket) }

        assertThat(result).isTrue()
        assertThat(runBlocking { secondRepository.all() }).isEmpty()
    }

    @Test
    fun all() {
    }
}