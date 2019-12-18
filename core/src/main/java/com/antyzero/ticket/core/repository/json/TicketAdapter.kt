package com.antyzero.ticket.core.repository.json

import com.antyzero.ticket.core.model.Ticket
import com.squareup.moshi.*


object TicketAdapter : JsonAdapter<Ticket<*>>() {

    private val moshi = Moshi.Builder().build()
    private val adapterAny = moshi.adapter(Any::class.java)

    @FromJson
    override fun fromJson(reader: JsonReader): Ticket<*> {

        reader.beginObject()

        reader.skipName()
        val id = reader.nextString()

        reader.skipName()
        val statusType = reader.nextString()

        reader.skipName()
        val statusClass = Ticket.Status::class.java.classLoader.loadClass(statusType)
        val status = moshi.adapter(statusClass).fromJson(reader) as Ticket.Status

        reader.skipName()
        val dataType = reader.nextString()

        reader.skipName()
        val dataClass = Ticket.Status::class.java.classLoader.loadClass(dataType)
        val data = moshi.adapter(dataClass).fromJson(reader) as Ticket.Data

        reader.endObject()

        return Ticket(id, status, data)
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Ticket<*>?) {

        requireNotNull(value) { "Null value is not supported" }

        writer.beginObject()

        writer.name("id")
        writer.value(value.id)

        writer.name("statusType")
        writer.value(value.status::class.java.name.toString())

        writer.name("status")
        adapterAny.toJson(writer, value.status)

        val dataType = value.dataType().java
        writer.name("dataType")
        writer.value(dataType.name.toString())

        writer.name("data")
        adapterAny.toJson(writer, value.data)

        writer.endObject()
    }

    private object TestData : Ticket.Data()
}