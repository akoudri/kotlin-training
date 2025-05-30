package com.akfc.training.com.akfc.training

import kotlin.math.sqrt

val f: (Int) -> Int = { x -> x * x }

val g: (Int) -> Int = { x -> x + 5 }

fun double(x: Int): Int = x * 2
fun square(x: Int): Int = x * x

fun applyOperation(x: Int, y: Int, op: (Int, Int) -> Int) : Int {
    return op(x, y)
}

fun mesurerTemps(op : () -> Unit) : Long {
    val start = System.currentTimeMillis()
    op()
    val duration = System.currentTimeMillis() - start
    return duration
}

data class Vector(val x: Int, val y: Int) {
    operator fun times(other: Vector) : Int {
        return this.x * other.y - this.y * other.x
    }
}

tailrec fun sumFromOneToN(n: Int, accumulator: Int = 0): Int =
    if (n == 0) accumulator else sumFromOneToN(n - 1, accumulator + n)

fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    if (this == 2) return true
    if (this % 2 == 0) return false

    val sqrt = sqrt(this.toDouble()).toInt()
    for (i in 3..sqrt step 2) {
        if (this % i == 0) return false
    }
    return true
}

fun getEvenNumbers(numbers: IntArray): IntArray = numbers.filter { it % 2 == 0 }.toIntArray()

fun myFilter(numbers: IntArray, op: (Int) -> Boolean): IntArray = numbers.filter { op(it) }.toIntArray()

fun toUpperCase(strings: List<String>): List<String> = strings.map(String::uppercase)

fun average(numbers: List<Double>): Double =
    try {
        numbers.reduce { sum, num -> sum + num } / numbers.size
    } catch (e: ArithmeticException) {
        throw IllegalArgumentException("La liste est vide", e)
    }

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = { x -> f(g(x)) }

/*fun main() {
    val doubleThenSquare = compose(::square, ::double)
    println(doubleThenSquare(3))

    val squareThenDouble = compose(::double, ::square)
    println(squareThenDouble(3))

    myFilter(intArrayOf(2, 3, 4, 5)){ x -> x % 2 == 0}.forEach { println(it) }

    println(1009.isPrime())
}*/

fun main() {
    val l = (1..5).toMutableList()
        .also { println(it) }
        .apply { add(6) }
        .also { println(it) }
        .run { size }
        .also { println("Size = ${it}")}

    val sb = StringBuilder()
    val h = with(sb) {
        append("Hello ")
        append("World")
        toString()
    }.also { println(it) }
}
