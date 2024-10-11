package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*

fun main() = runBlocking {
    var counter = 0
    val numberOfJobs = 2
    val numberOfIncrements = 200

    val jobs = List(numberOfJobs) {
        launch(Dispatchers.Default) {
            repeat(numberOfIncrements) {
                counter++
            }
        }
    }

    jobs.forEach { it.join() }
    println("Final counter value: $counter")
}