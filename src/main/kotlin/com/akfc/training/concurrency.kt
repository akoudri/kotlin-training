package com.akfc.training.com.akfc.training

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

var counter = 0

suspend fun sayHello() {
    delay(300L)
    println("Hello coroutine")
    counter++
}

fun main() {
    println("Start")
    runBlocking {
        val job = launch(CoroutineName("myCoroutine")) {
            delay(1000L)
            println("Task 1 from ${coroutineContext.get(CoroutineName.Key)}")
        }

        job.invokeOnCompletion { println("Job 1 completed")}

        GlobalScope.launch {
            delay(500L)
            println("Task 2")
        }

        coroutineScope {
            launch(Dispatchers.Default) {
                delay(1500L)
                println("Task 3")
            }
            launch {
                sayHello()
            }
            launch { sayHello() }
        }
    }
    println("End $counter")
}