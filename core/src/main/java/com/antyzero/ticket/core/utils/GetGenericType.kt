package com.antyzero.ticket.core.utils

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.allSupertypes

fun genericOfInterface(input: Any, interfaceClass: KClass<*>): List<KType> {

    val interfaces = input::class.interfaces

    require(interfaces.isNotEmpty()) { "No interfaces implemented in ${input::class}" }
    require(interfaceClass.isInterface) { "Given interface class: [$interfaceClass] is not an interface" }

    check(interfaces.contains(interfaceClass)) { "Given input does not implement $interfaceClass" }

    val interfaceType = input::class.allSupertypes
        .first { (it.classifier as? KClass<*>) == interfaceClass }

    return interfaceType.arguments
        .map { it.type }
        .requireNoNulls()
}