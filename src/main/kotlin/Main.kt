package com.akfc.training

import com.akfc.training.com.akfc.training.persons.Day
import com.akfc.training.com.akfc.training.persons.Man

data class Point(val x: Int, val y: Int)

inline fun <reified T> affiche(t: T) {
    if (t is String) {
        println(t)
    } else {
        println(t)
    }
}

class Box<T>(val t : T) {
    fun affiche() {
        if (t is String) {
            println(t)
        }
    }
}

fun main() {
    affiche(25.5)
    val b = Box(12)
    b.affiche()
}