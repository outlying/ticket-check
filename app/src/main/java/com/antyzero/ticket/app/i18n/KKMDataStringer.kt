package com.antyzero.ticket.app.i18n

import android.content.Context
import com.antyzero.ticket.core.provider.kkm.KKMData

object KKMDataStringer : BaseTicketDataStringer<KKMData>(KKMData::class.java) {

    override fun i18n(context: Context, data: KKMData): CharSequence {
        return when (data) {
            is KKMData.Normal -> ""
            is KKMData.Student -> ""
        }
    }
}