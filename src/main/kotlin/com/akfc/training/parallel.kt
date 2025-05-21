package com.akfc.training.com.akfc.training

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration

var counter = 0

suspend fun sayHello() {
    delay(3000L)
    println("Hello World")
}

fun incr() {
    for (i in 1..100_000) {
        counter++
    }
}

suspend fun computeStuff() : Int {
    delay(2000L)
    return 45
}

fun main() {
    runBlocking {
        launch(Dispatchers.IO) {
            incr()
            println(currentCoroutineContext())
        }
        launch { incr() }
        println(currentCoroutineContext())
    }
    println(counter)
}