package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.utils.WierdoData
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class JsonFileRepositoryTest {

    @Test
    fun `verify adapter`() {
        val ticket = Ticket(id = "", status = Ticket.Status.Invalid, data = WierdoData("name"))
        val adapter = JsonFileRepository.createAdapter()

        val result = adapter.toJson(listOf(ticket))

        assertThat(result).isNotEmpty()
    }
}