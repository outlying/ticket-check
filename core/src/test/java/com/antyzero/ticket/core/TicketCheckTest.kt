package com.antyzero.ticket.core

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.DumbRepository
import com.antyzero.ticket.core.validator.TicketValidator
import org.junit.jupiter.api.Test

internal class TicketCheckTest {


    @Test
    internal fun creation() {
        TicketCheck(DumbRepository, listOf(TestValidator()))
    }

    private class TestData : Ticket.Data()

    private class TestValidator : TicketValidator<TestData> {

        var status: Ticket.Status? = null

        override fun isValid(ticket: Ticket<TestData>): Ticket.Status? = status
    }
}