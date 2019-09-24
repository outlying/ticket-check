package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.utils.WierdoData
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDate

class JsonFileRepositoryTest {

    @Test
    fun `serialize`() {
        val ticket = Ticket(
            id = "some ID",
            status = Ticket.Status.Valid(until = LocalDate.MIN),
            data = WierdoData("name")
        )
        val adapter = JsonFileRepository.createAdapter()

        val result = adapter.toJson(listOf(ticket)).also { println(it) }

        assertThat(result).isNotEmpty()
    }

    @Test
    fun `deserialize`() {
        val json =
            "[{\"id\":\"some ID\",\"statusType\":\"com.antyzero.ticket.core.model.Ticket\$Status\$Valid\",\"status\":{\"until\":{\"day\":1,\"month\":1,\"year\":-999999999}},\"dataType\":\"com.antyzero.ticket.core.utils.WierdoData\",\"data\":{\"name\":\"name\"}}]"
        val adapter = JsonFileRepository.createAdapter()

        val result = adapter.fromJson(json)

        assertThat(result).isNotNull()
    }
}