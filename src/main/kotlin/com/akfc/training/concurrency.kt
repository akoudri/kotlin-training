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

/*fun main() {
    runBlocking {
        launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                // Perform I/O operation
            }
            // Update UI with the result
        }
    }
}*/

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Création d'un contexte personnalisé
    val customContext = Dispatchers.Default + CoroutineName("MonContextePersonnalisé")

    // Lancement d'une coroutine avec le contexte personnalisé
    val job = launch(customContext) {
        // Accès aux éléments du contexte
        val dispatcher = coroutineContext[CoroutineDispatcher]
        val name = coroutineContext[CoroutineName]?.name

        println("Coroutine en cours d'exécution sur ${Thread.currentThread().name}")
        println("Nom de la coroutine : $name")
        println("Dispatcher utilisé : $dispatcher")

        delay(1000) // Simulation d'un travail long
        println("Travail terminé")
    }

    job.join() // Attente de la fin de la coroutine
}

