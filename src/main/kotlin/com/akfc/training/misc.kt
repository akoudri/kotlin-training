package com.akfc.training.com.akfc.training

class Configuration(val host: String = "localhost", val port: Int = 8080) {
    companion object {
        fun getInstance() = Configuration()
    }
}

fun <T> printItem(item: T) {
    println(item)
}

class Box<T>(var content: T) {
    fun get(): T = content
}

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<T>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }
}

fun acceptStrings(strings: List<out CharSequence>) {
    strings.forEach { println(it) }
}

fun addComparables(dest: MutableList<in Int>) {
    dest.add(42)
}

inline fun <reified T> isA(value: Any) = value is T

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    // ...
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

object DatabaseConnection {
    fun connect() = println("Connected to database")
}

/*fun main() {
    DatabaseConnection.connect()
}*/
