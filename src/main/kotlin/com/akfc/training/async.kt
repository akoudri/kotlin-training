package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Requesting operation")
    val result = withContext(Dispatchers.Default) {
        performOperation()
    }
    println("Response = $result")
}

suspend fun performOperation(): Int {
    println("Performing operation")
    delay(3000) // Non-blocking delay
    return 42
}