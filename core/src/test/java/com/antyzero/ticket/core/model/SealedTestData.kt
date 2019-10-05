package com.antyzero.ticket.core.model

sealed class SealedTestData : Ticket.Data() {
    data class A(val id: Any) : SealedTestData()
    data class B(val id: Any) : SealedTestData()
}