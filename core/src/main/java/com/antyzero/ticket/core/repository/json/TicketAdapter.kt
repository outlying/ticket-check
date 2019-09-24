package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.squareup.moshi.*


object TicketAdapter : JsonAdapter<Ticket<*>>() {

    private val moshi = Moshi.Builder().build()
    private val adapterAny = moshi.adapter(Any::class.java)

    @FromJson
    override fun fromJson(reader: JsonReader): Ticket<*> {

        return Ticket(
            "123", Ticket.Status.Invalid, TestData
        )
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Ticket<*>?) {

        if (value == null) {
            throw IllegalArgumentException("Null value is not supported")
        }

        writer.beginObject()

        writer.name("id")
        writer.value(value.id.toString())

        writer.name("statusType")
        writer.value(value.status::class.java.canonicalName.toString())

        writer.name("status")
        adapterAny.toJson(writer, value.status)

        val dataType = value.dataType().java
        writer.name("dataType")
        writer.value(dataType.canonicalName.toString())

        writer.name("data")
        adapterAny.toJson(writer, value.data)

        writer.endObject()
    }

    private object TestData : Ticket.Data()
}