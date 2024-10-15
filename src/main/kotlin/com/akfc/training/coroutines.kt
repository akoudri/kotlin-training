package com.akfc.training.com.akfc.training

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.channels.*

suspend fun delayedMessage() {
    delay(1000) // Simule un délai de 1 seconde
    println("Message après un délai de 1 seconde")
}

suspend fun fetchUserData(userId: Int): String {
    delay(1000) // Simule une opération asynchrone prenant 1 seconde
    return "User $userId data"
}

suspend fun fetchUserPosts(userId: Int): String {
    delay(1500) // Simule une opération asynchrone prenant 1,5 seconde
    return "User $userId posts"
}

suspend fun launchCoroutines() {
    val job = Job()
    val scope = CoroutineScope(job)

    repeat(10) { i ->
        scope.launch {
            val delay = Random.nextLong(1000L, 5000L)
            delay(delay)
            println("Coroutine $i finished after ${delay}ms")
        }
    }

    job.join()
    println("All coroutines have finished")
}

suspend fun simulateFileDownload(fileName: String): String {
    val downloadTime = Random.nextLong(500, 2000) // Simule un temps de téléchargement aléatoire entre 500ms et 2s
    delay(downloadTime)
    return "Fichier $fileName téléchargé en ${downloadTime}ms"
}

suspend fun downloadFilesInParallel() {
    val totalTime = measureTimeMillis {
        coroutineScope {
            val downloads = List(5) { index ->
                async {
                    simulateFileDownload("fichier_${index + 1}")
                }
            }

            downloads.awaitAll().forEach { result ->
                println(result)
            }
        }
    }

    println("Temps total de téléchargement : ${totalTime}ms")
}

suspend fun simulateApiRequest(): String {
    return withTimeout(2000L) { // 2 secondes de timeout
        try {
            val delay = Random.nextLong(500, 3000) // Délai aléatoire entre 500ms et 3s
            delay(delay)

            if (Random.nextBoolean()) { // 50% de chance d'échec
                throw Exception("API request failed")
            }

            "API request successful after ${delay}ms"
        } catch (e: TimeoutCancellationException) {
            throw e // Relancer l'exception de timeout pour la gérer à l'extérieur
        } catch (e: Exception) {
            throw e // Relancer les autres exceptions pour les gérer à l'extérieur
        }
    }
}

// Représente une tâche avec un ID
data class Task(val id: Int)

// Simule le traitement d'une tâche avec un délai aléatoire
suspend fun processTask(task: Task) {
    val processingTime = Random.nextLong(1000, 3000) // Délai entre 1 et 3 secondes
    delay(processingTime)
    println("Task ${task.id} processed by ${Thread.currentThread().name} in ${processingTime}ms")
}

// Fonction pour créer et gérer le pool de workers
suspend fun workerPool(workerCount: Int, tasks: List<Task>) = coroutineScope {
    // Création du channel pour distribuer les tâches
    val channel = Channel<Task>()

    // Lancement des workers
    repeat(workerCount) {
        launch {
            for (task in channel) {
                processTask(task)
            }
        }
    }

    // Envoi des tâches dans le channel
    for (task in tasks) {
        channel.send(task)
    }

    // Fermeture du channel une fois toutes les tâches envoyées
    channel.close()
}

/*
fun main() = runBlocking {
    GlobalScope.launch {
        delayedMessage()
    }
    delay(1500) // Attendre un peu plus longtemps que le délai pour voir le message
}*/

/*
fun main() = runBlocking {
    val userId = 1

    val job1 = launch {
        val userData = fetchUserData(userId)
        println("User data: $userData")
    }

    val job2 = launch {
        val userPosts = fetchUserPosts(userId)
        println("User posts: $userPosts")
    }

    job1.join()
    job2.join()

    println("All tasks completed")
}*/

/*
suspend fun main() {
    repeat(5) { // Répéter 5 fois pour voir différents résultats
        try {
            val result = simulateApiRequest()
            println(result)
        } catch (e: TimeoutCancellationException) {
            println("Request timed out after 2 seconds")
        } catch (e: Exception) {
            println("Request failed: ${e.message}")
        }
        println("---")
    }
}*/

/*
suspend fun main() {
    val workerCount = 3 // Nombre de workers
    val taskCount = 10 // Nombre de tâches à traiter

    val tasks = List(taskCount) { Task(it) }

    println("Starting worker pool with $workerCount workers for $taskCount tasks")

    val time = measureTimeMillis {
        workerPool(workerCount, tasks)
    }

    println("All tasks completed in $time ms")
}*/

fun main() = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (i in 1..5) {
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (value in channel) {
            println("Received: $value")
        }
    }

    println("All values received")
}