package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*
import java.util.concurrent.Semaphore

fun main() = runBlocking {
    val semaphore = Semaphore(3) // Allow 3 concurrent operations
    val jobs = List(10) { jobId ->
        launch {
            semaphore.acquire() // Acquire a permit
            try {
                performOperation(jobId)
            } finally {
                semaphore.release() // Release the permit
            }
        }
    }
    jobs.joinAll()
}

suspend fun performOperation(id: Int) {
    println("Starting operation $id")
    delay(1000) // Simulate work
    println("Finished operation $id")
}