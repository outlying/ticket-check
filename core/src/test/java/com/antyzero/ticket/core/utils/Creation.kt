package com.antyzero.ticket.core.utils

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import com.antyzero.ticket.core.repository.json.JsonFileRepository
import java.io.File
import kotlin.random.Random


fun createTicket(
    id: Any = Random.nextLong()
): Ticket<*> {
    return Ticket(
        id = id,
        status = Ticket.Status.Invalid,
        data = WierdoData(
            Random.nextLong().toString()
        )
    )
}

data class WierdoData(
    val name: String
) : Ticket.Data()

fun createRepository(file: File = createFile()): Repository {
    return JsonFileRepository(file)
}

fun createFile(id: Long = Random.nextLong()): File {
    return File.createTempFile(id.toString(), ".json")
}