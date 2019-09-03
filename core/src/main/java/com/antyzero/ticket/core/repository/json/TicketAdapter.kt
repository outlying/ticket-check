package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter


class TicketAdapter : JsonAdapter<Ticket<*>>() {

    override fun fromJson(reader: JsonReader): Ticket<*> {
        
        return Ticket(
            "123", Ticket.Status.Invalid, TestData
        )
    }

    override fun toJson(writer: JsonWriter, value: Ticket<*>?) {

    }

    private object TestData : Ticket.Data()

}