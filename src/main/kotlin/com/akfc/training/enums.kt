package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker
import kotlin.random.Random

enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

enum class Color(val rgb: Int) {
    RED(0xFF0000) {
        override fun print() { println("This is red") }
    },
    GREEN(0x00FF00) {
        override fun print() { println("This is green") }
    };

    abstract fun print()
}

enum class Priority {
    HIGH,
    MEDIUM,
    LOW
}

class Task() {
    companion object {
        val faker = Faker()
    }
    val name : String = Task.faker.job().title()
    val priority = when(Random.nextInt(3)) {
        0 -> Priority.HIGH
        1 -> Priority.MEDIUM
        else -> Priority.LOW
    }

    override fun toString(): String {
        return this.name
    }

}

fun main() {
    val tasks = (1..10).asSequence().map { Task() }
    tasks.forEach { println("${it.name} : ${it.priority}") }
    println()
}
