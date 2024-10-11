package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*

/*fun main() {
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        println("Hello")
    }
    job.cancel()
}*/

/*
fun main() = runBlocking {
    val result = async {
        delay(1000) // Simulate a long-running task
        "Hello, Coroutines!"
    }
    println("Doing some other work...")
    println(result.await())
}*/

fun main() {
    runBlocking {
        launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                // Perform I/O operation
            }
            // Update UI with the result
        }
    }
}
