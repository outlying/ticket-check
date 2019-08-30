package com.antyzero.ticket.core.utils

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class GetGenericTypeKtTest {

    @Test
    fun genericOfInterface() {
        assertThat(genericOfInterface(SameString(), Some::class)).isEqualTo(String::class)
    }

    @Test
    internal fun `check if non interface fail`() {
        try {
            genericOfInterface(Any(), Any::class)
        } catch (e: Exception) {
            assertThat(e::class.java).isEqualTo(IllegalArgumentException::class.java)
        }
    }

    @Test
    internal fun `check if interface pass`() {
        genericOfInterface(object : Some<Int> {}, Some::class)
    }

    @Test
    internal fun `check if interface is implemented`() {
        try {
            genericOfInterface(object : Some<Int> {}, Other::class)
        } catch (e: Exception) {
            assertThat(e::class.java).isEqualTo(IllegalStateException::class.java)
        }
    }

    interface Some<T>
    interface Other<T>

    class SameString : Some<String>
}