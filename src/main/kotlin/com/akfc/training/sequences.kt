package com.akfc.training.com.akfc.training

fun main() {
    val sequence = generateSequence(1) { it + 1 }
    val result = sequence.take(10).toList()
    println(result)
}
