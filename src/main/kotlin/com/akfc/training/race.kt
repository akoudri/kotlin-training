package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*

fun main() = runBlocking {
    var counter = 0
    val numberOfJobs = 100
    val numberOfIncrements = 1_000_000
    val lock = Any()

    val jobs = List(numberOfJobs) {
        launch(Dispatchers.Default) {
            repeat(numberOfIncrements) {
                synchronized(lock) {
                    counter++
                }
            }
        }
    }

    jobs.forEach { it.join() }
    println("Final counter value: $counter")
}