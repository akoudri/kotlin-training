package com.akfc.training.com.akfc.training

fun main() {
    mutableListOf("Bananes", "Pommes", "Choux")
        .apply { add("Carottes") }
        .also { println(it) }
        .apply { remove("Choux") }
        .also { println(it) }
        .apply { add("Mangues") }
        .also { println(it) }
        .run { toList() }

    mutableSetOf("Bananes", "Pommes", "Choux")
        .apply { add("Carottes") }
        .apply { add("Carottes") }
        .also { println(it) }
        .apply { remove("Choux") }
        .also { println(it) }
        .apply { add("Mangues") }
        .also { println(it) }
        .run { toSet() }
}