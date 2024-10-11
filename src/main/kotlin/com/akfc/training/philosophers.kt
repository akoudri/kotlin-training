package com.akfc.training.com.akfc.training

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun main() {
    val fourchette1 = ReentrantLock()
    val fourchette2 = ReentrantLock()
    val fourchette3 = ReentrantLock()
    Philosopher("Socrate", fourchette1, fourchette2).start()
    Philosopher("Platon", fourchette2, fourchette3).start()
    // Philosopher("Kant", fourchette3, fourchette1).start() // First case of DEADLOCK !!!
    Philosopher("Kant", fourchette1, fourchette3).start() // NO DEADLOCK
}

class Philosopher(
    private val name: String,
    private val firstFork: Lock,
    private val secondFork: Lock
) : Thread() {

    override fun run() {
        // Get forks, eat one sweet and release the fork
        // Do it while there is any food left
        while (sweetCount > 0) {
            firstFork.lock()
            secondFork.lock()
            try {
                if (sweetCount > 0) {
                    sweetCount--
                    println("$name has eaten one sweet")
                    if (sweetCount == 10) {
                        val a = 10 / 0 // 2nd case of deadlock
                        // can be solved using try catch finally (to release the lock)
                    }
                }
            } finally {
                secondFork.unlock()
                firstFork.unlock()
            }
        }
    }

    companion object {
        private var sweetCount = 5_000
    }
}