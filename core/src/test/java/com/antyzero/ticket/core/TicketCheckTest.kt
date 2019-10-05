package com.antyzero.ticket.core

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.DumbRepository
import com.antyzero.ticket.core.validator.TicketValidator
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
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
                runBlocking {
                    addTicket(
                        Ticket(
                            id = "asd",
                            data = TestDataButDifferent(),
                            status = Ticket.Status.Invalid
                        )
                    )
                }
            }
        } catch (e: Exception) {
            assertThat(e::class.java).isEqualTo(IllegalStateException::class.java)
        }
    }

    @Test
    internal fun `data subclass should also be valid`() {
        TicketCheck(DumbRepository, listOf(SealedTestDataValidator())).apply {
            runBlocking {
                addTicket(
                    Ticket(
                        id = "Some Id",
                        status = Ticket.Status.Invalid,
                        data = SealedTestData.A(123)
                    )
                )
            }
        }
    }

    private sealed class SealedTestData : Ticket.Data() {
        data class A(val id: Any) : SealedTestData()
        data class B(val id: Any) : SealedTestData()
    }

    private class SealedTestDataValidator : TicketValidator<SealedTestData> {
        override suspend fun isValid(ticket: Ticket<SealedTestData>): Ticket.Status? {
            when (ticket.data) {
                is SealedTestData.A -> "do A"
                is SealedTestData.B -> "do B"
            }
            return null
        }
    }

    private class TestData : Ticket.Data()
    private class TestDataButDifferent : Ticket.Data()

    private class TestValidator : TicketValidator<TestData> {
        var status: Ticket.Status? = null
        override suspend fun isValid(ticket: Ticket<TestData>): Ticket.Status? = status
    }
}