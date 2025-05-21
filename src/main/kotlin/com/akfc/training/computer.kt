package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker
import java.util.Date
import java.util.UUID

open class Computer {
    var capacity : Int = 0
    lateinit var drive : Drive
    val card = Card()

    companion object {
        var nbCard = 0
    }

    class Card {
        init {
            Computer.nbCard ++
        }
    }

    inner class Drive(val capacity : Int = 200) {
        init {
            this@Computer.capacity += this.capacity
        }
    }
}

object VConfig {
    fun print() {
        println("V1.0")
    }
}

data class LUser(val id: UUID, val firstname: String, val lastname: String)

object Log {
    fun message(s : String) {
        println("${Date()}: ${s}")
    }
}

class App {
    val users = arrayListOf<LUser>()

    init {
        val faker = Faker()
        (1..10).asSequence()
            .map { faker.name() }
            .map { LUser(UUID.randomUUID(), it.firstName(), it.lastName()) }
            .forEach {
                Log.message("${it.firstname} ${it.lastname} added")
                users.add(it)
            }
    }
}

fun main() {
    val app = App()
    println(app.users.size)
}