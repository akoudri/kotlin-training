package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*

/*fun main() = runBlocking {
    println("Requesting operations")
    val results = (1..5).map { i ->
        async(Dispatchers.Default) {
            performOperation(i)
        }
    }.awaitAll()

    results.forEachIndexed { index, result ->
        println("Response $index = $result")
    }
}*/

suspend fun performOperation(id: Int): Int {
    println("Performing operation $id")
    delay(3000) // Non-blocking delay
    return id * 42
}