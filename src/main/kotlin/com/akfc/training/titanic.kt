package com.akfc.training.com.akfc.training

import java.io.File
import java.util.regex.Pattern
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

enum class Sex {
    MALE,
    FEMALE
}

data class Customer(
    val pClass: Int,
    val survived: Boolean,
    val name: String,
    val sex: Sex,
    val age: Double?
) {
    fun fullName() : Array<String>? {
        val p = Pattern.compile("(\\w+), (\\w+)\\. (.*)")
        val m = p.matcher(name)
        return if (m.find()) {
            arrayOf(m.group(2), m.group(1), m.group(3))
        } else {
            null
        }
    }
}

class Titanic {
    private val customers: MutableList<Customer> = mutableListOf()

    init {
        loadData()
    }

    private fun loadData() {
        File("src/main/resources/titanic.csv").readLines().asSequence()
            .forEach {
                val scanner = Scanner(it)
                    .useDelimiter(";")
                    .useLocale(Locale.US)
                val pClass = scanner.nextInt()
                val survived = scanner.nextInt() != 0
                val name = scanner.next()
                val sex = when(scanner.next()) {
                    "male" -> Sex.MALE
                    else -> Sex.FEMALE
                }
                val age = when {
                    scanner.hasNextDouble() -> scanner.nextDouble()
                    scanner.hasNextInt() -> scanner.nextInt().toDouble()
                    else -> null
                }
                customers.add(Customer(pClass, survived, name, sex, age))
            }
    }

    fun head(n: Int = 5) {
        customers.take(n).forEach { println(it) }
    }

    fun tail(n: Int = 5) {
        customers.takeLast(n).forEach { println(it) }
    }

    fun getCustomers(): List<Customer> = customers.toList()
}

fun main() {
    val t = Titanic()
    t.head()
    println("-----------------")
    t.tail()
    println("-----------------")
    t.getCustomers().filter { it.sex == Sex.MALE }
        .mapNotNull { it.age }
        .average()
        .also { println(it) }
    t.getCustomers().take(5)
        .mapNotNull { it.fullName() }
        .map { it.joinToString("|") }
        .forEach { println(it) }
    println("-----------------")
    t.getCustomers()
        .groupBy ({ it.sex }, { it.age })
        .mapValues { it.value.filterNotNull().average() }
        .forEach { k, v -> println("$k -> $v") }


}