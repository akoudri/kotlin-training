package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

fun main() = runBlocking {
    var counter = 0
    val numberOfJobs = 2
    val numberOfIncrements = 200_000
    val lock = ReentrantLock()

    val jobs = List(numberOfJobs) {
        launch(Dispatchers.Default) {
            if (lock.tryLock()) {
                repeat(numberOfIncrements) {
                    counter ++
                }
            } else {
                println("Autre traitement")
            }
        }
    }

    jobs.forEach { it.join() }
    println("Final counter value: $counter")
}