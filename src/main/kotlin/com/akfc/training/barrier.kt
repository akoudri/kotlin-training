package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*
import java.util.concurrent.CyclicBarrier

fun main() = runBlocking {
    val participantCount = 5
    val barrier = CyclicBarrier(participantCount) {
        println("Barrier is opening!")
    }

    val jobs = List(participantCount) { id ->
        launch(Dispatchers.Default) {
            println("Participant $id is preparing")
            delay((500..1500).random().toLong()) // Random preparation time
            println("Participant $id is ready and waiting at the barrier")
            barrier.await() // Wait for all participants
            println("Participant $id has crossed the barrier")
        }
    }

    jobs.joinAll()
}
