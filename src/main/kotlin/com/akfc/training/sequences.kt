package com.akfc.training.com.akfc.training

fun sumOfSquares(numbers: Sequence<Int>): Int {
    return numbers
        .map { it * it }
        .sum()
}

fun filterAndTransform(strings: Sequence<String>): Sequence<String> {
    return strings
        .filter { it.length > 5 }
        .map { it.uppercase() }
}

fun fibonacciSequence(maxValue: Int): Sequence<Int> {
    return sequence {
        var a = 0
        var b = 1

        while (a <= maxValue) {
            yield(a)
            val sum = a + b
            a = b
            b = sum
        }
    }
}

fun main() {
    val sequence = generateSequence(1) { it + 1 }
    val result = sequence.take(10).toList()
    println(result)
    val fibo = fibonacciSequence(10).toList()
    println(fibo)
    val fibo2 = fibonacciSequence(100).withIndex().filter { it.index % 3 == 0 }.map { it.value }.toList()
    println(fibo2)
    val fibo3 = fibonacciSequence(100).windowed(3, 1, true).toList()
    println(fibo3)
}
