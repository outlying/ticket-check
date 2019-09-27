package com.antyzero.ticket.core.utils

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.repository.Repository
import com.antyzero.ticket.core.repository.json.JsonFileRepository
import java.io.File
import kotlin.math.absoluteValue
import kotlin.random.Random


fun createTicket(
    id: String = Random.nextInt().absoluteValue.toString(),
    status: Ticket.Status = Ticket.Status.Invalid
): Ticket<*> {
    return Ticket(
        id = id,
        status = status,
        data = WierdoData(
            Random.nextLong().toString()
        )
    )
}

data class WierdoData(
    val name: String
) : Ticket.Data()

fun createRepository(file: File = createFile()): Repository {
    return JsonFileRepository(file).also {
        println("Created repository $it")
    }
}

fun createFile(id: Long = randomFileId()): File {
    return File.createTempFile(id.toString(), ".json").also {
        println("Created JSON file $it")
    }
}

fun tmpFile(id: Long = randomFileId(), block: (File) -> Unit) {
    with(createFile(id)) {
        block.invoke(this)
        delete()
    }
}

private fun randomFileId() = Random.nextLong().hashCode().absoluteValue.toLong()