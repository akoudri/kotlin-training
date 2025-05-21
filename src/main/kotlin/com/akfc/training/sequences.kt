package com.akfc.training.com.akfc.training

fun sumOfSquares(numbers : Sequence<Int>) : Int =
    numbers
        .map { it * it }
        .sum()

fun multipleSequence(m : Int) : Sequence<Int> {
    return sequence {
        var a = 0
        while (true) {
            if (a % m == 0) yield(a)
            a ++
        }
    }
}

fun primeSeq() : Sequence<Int> {
    return sequence {
        var a = 0
        while (true) {
            if (a.isPrime()) yield(a)
            a++
        }
    }
}

fun fiboSeq() : Sequence<Int> {
    return sequence {
        var a = 0
        var b = 1
        while (true) {
            yield(a)
            val sum = a + b
            a = b
            b = sum
        }
    }
}

fun main() {
    val seq1 = (1..100).asSequence()
    val seq2 = (1..10).asSequence()
    val seq = seq1 zip seq2
    seq1.takeWhile{ it < 12 }.map{ it * it }.forEach { println(it) }
}
