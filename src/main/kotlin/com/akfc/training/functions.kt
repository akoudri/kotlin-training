package com.akfc.training.com.akfc.training

fun double(x: Int): Int = x * 2
fun square(x: Int): Int = x * x

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun main() {
    val doubleThenSquare = compose(::square, ::double)
    println(doubleThenSquare(3)) // Output: 36 (3 doubled is 6, squared is 36)

    val squareThenDouble = compose(::double, ::square)
    println(squareThenDouble(3)) // Output: 18 (3 squared is 9, doubled is 18)
}