package com.antyzero.ticket.core

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.DumbRepository
import com.antyzero.ticket.core.validator.TicketValidator
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class TicketCheckTest {

    @Test
    internal fun creation() {
        TicketCheck(DumbRepository, listOf(TestValidator()))
    }

    @Test
    internal fun `unsupported ticked have to fail`() {
        try {
            TicketCheck(DumbRepository, listOf(TestValidator())).apply {
                addTicket(
                    Ticket(
                        id = "asd",
                        data = TestDataButDifferent(),
                        status = Ticket.Status.Invalid
                    )
                )
            }
        } catch (e: Exception) {
            assertThat(e::class.java).isEqualTo(IllegalStateException::class.java)
        }
    }

    private class TestData : Ticket.Data()
    private class TestDataButDifferent : Ticket.Data()

    private class TestValidator : TicketValidator<TestData> {
        var status: Ticket.Status? = null
        override fun isValid(ticket: Ticket<TestData>): Ticket.Status? = status
    }
}