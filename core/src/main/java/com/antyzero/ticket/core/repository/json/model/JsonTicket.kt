package com.antyzero.ticket.core.repository.json.model

data class JsonTicket(
    val id: String,
    val idClass: String,
    val status: String,
    val dataClass: String,
    val dataString: String
)