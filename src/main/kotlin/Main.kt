package com.akfc.training

import com.akfc.training.com.akfc.training.Person

fun main() {
    val result = listOf(1, 2, 3, 4, 5)
        .asSequence()
        .filter { it % 2 != 0 }
        .map { it * it }
        .toList()

    result.forEach { println(it) }

    val persons = List<Person>(10) { Person(null, it) }

    persons.forEach { println(it) }
}