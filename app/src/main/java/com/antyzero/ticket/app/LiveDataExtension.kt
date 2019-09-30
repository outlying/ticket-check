package com.antyzero.ticket.app

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, block: (T) -> Unit) {
    this.observe({ lifecycleOwner.lifecycle }, block)
}