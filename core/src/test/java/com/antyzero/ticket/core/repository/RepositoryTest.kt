package com.antyzero.ticket.core.repository

import com.antyzero.ticket.core.utils.createFile
import com.antyzero.ticket.core.utils.createRepository
import com.antyzero.ticket.core.utils.createTicket
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.random.Random

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
    internal fun pasdapsdp() {
        val id = Random.nextLong()
        val file = createFile(id)
        val ticket = createTicket()

        runBlocking { createRepository(file).addTicket(ticket) }

        val all = runBlocking { createRepository(file).all() }
        assertThat(all).contains(ticket)

        file.delete()
    }

    @Test
    fun updateTicket() {
    }

    @Test
    fun removeTicket() {
    }

    @Test
    fun all() {
    }
}