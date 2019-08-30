package com.antyzero.ticket.core.provider.kkm

import com.antyzero.ticket.core.model.Ticket

data class KKMData(
    val clientId: Long
) : Ticket.Data()

