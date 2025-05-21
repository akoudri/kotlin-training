package com.akfc.training.com.akfc.training

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class Fibo {

    fun recursive(n: Int): Long {
        require(n > 0) { "N shall be greater than 0" }
        if (n <= 2) return 1
        return recursive(n - 1) + recursive(n - 2)
    }

    fun cache(n: Int, map: MutableMap<Int, Long>): Long {
        require(n > 0)
        if (n <= 2) return 1
        if (map.containsKey(n)) return map[n]!!
        val res = cache(n - 1, map) + cache(n - 2, map)
        map[n] = res
        return res
    }

    fun slide(n: Int): Long {
        require(n > 0)
        if (n <= 2) return 1
        var a: Long
        var b = 1L
        var somme = 2L
        for (i in 3 until n) {
            a = b
            b = somme
            somme = a + b
        }
        return somme
    }

    // Tail-recursive function to compute Fibonacci numbers
    tailrec fun fibonacciUsingTailRecursion(n: Int, a: Int = 0, b: Int = 1): Int {
        return when (n) {
            0 -> a
            1 -> b
            else -> fibonacciUsingTailRecursion(n - 1, b, a + b)
        }
    }

    fun displayEvenNumbers(n: Int) {
        require(n > 2)
        val or3 = ((sqrt(5.0) + 1) / 2).pow(3)
        var num = 2L
        while (num <= n) {
            print("$num ")
            num = round(num * or3).toLong()
        }
        println()
    }

    fun getEvenNumbers(n: Int): List<Long> {
        require(n > 2)
        val res = mutableListOf<Long>()
        val or3 = ((sqrt(5.0) + 1) / 2).pow(3)
        var num = 2L
        while (num <= n) {
            res.add(num)
            num = round(num * or3).toLong()
        }
        return res
    }
}

fun main() {
    val fibo = Fibo()
    /*val start = System.currentTimeMillis()
    val res = fibo.recursive(200)
    val duration = System.currentTimeMillis() - start
    println("Computed $res in $duration ms")
    fibo.displayEvenNumbers(200)*/

    val start = System.currentTimeMillis()
    val res = fibo.getEvenNumbers(200)
    val duration = System.currentTimeMillis() - start
    println("Computed ${res.size} in $duration ms")
    res.forEach { println(it) }

}
