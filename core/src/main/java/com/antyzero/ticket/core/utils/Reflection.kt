package com.antyzero.ticket.core.utils

import kotlin.reflect.KClass
import kotlin.reflect.full.allSuperclasses

val KClass<*>.isInterface get() = java.isInterface

val KClass<*>.interfaces
    get() = allSuperclasses
        .filter { it.isInterface }