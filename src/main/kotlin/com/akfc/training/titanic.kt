package com.akfc.training.com.akfc.training

import java.util.regex.Pattern
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

enum class Sex {
    MALE, FEMALE
}

data class Customer(
    val pClass: Int,
    val survived: Boolean,
    val name: String,
    val sex: Sex,
    val age: Double
) {
    fun fullName(): Array<String>? {
        val pattern = Pattern.compile("(\\w+), (\\w+)\\. (.*)")
        val matcher = pattern.matcher(name)
        return if (matcher.find()) {
            arrayOf(matcher.group(2), matcher.group(1), matcher.group(3))
        } else {
            null
        }
    }

    fun category(): String = when {
        age < 20.0 -> "20-"
        age < 40.0 -> "20-40"
        age < 60.0 -> "40-60"
        else -> "60+"
    }

    override fun toString(): String {
        return "$pClass\t$survived\t$name\t${sex.name}\t$age"
    }
}

class Titanic {
    private val customers: MutableList<Customer> = mutableListOf()

    init {
        loadData()
    }

    private fun loadData() {
        try {
            Files.newBufferedReader(Path.of("src/main/resources/titanic.csv")).use { br ->
                br.lineSequence().forEach { line ->
                    val scan = Scanner(line).useDelimiter(";").useLocale(Locale.US)
                    val pClass = scan.nextInt()
                    val survived = scan.nextInt() != 0
                    val name = scan.next()
                    val sex = when (scan.next()) {
                        "male" -> Sex.MALE
                        else -> Sex.FEMALE
                    }
                    val age = when {
                        scan.hasNextDouble() -> scan.nextDouble()
                        scan.hasNextInt() -> scan.nextInt().toDouble()
                        else -> -1.0
                    }
                    customers.add(Customer(pClass, survived, name, sex, age))
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun head(n: Int) {
        customers.take(n).forEach(::println)
    }

    fun tail(n: Int) {
        customers.takeLast(n).forEach(::println)
    }

    fun getCustomers(): List<Customer> = customers.toList()
}

fun main() {
    val t = Titanic()
    t.head(5)
    println("-------------------")
    t.tail(5)
    println("-------------------")
    val avg = t.getCustomers()
        .filter { it.sex == Sex.MALE && it.age > 0 }
        .map { it.age }
        .average()
    println("Age moyen des hommes : $avg")
    println("-------------------")
    t.getCustomers()
        .take(5)
        .mapNotNull { it.fullName() }
        .map { it.joinToString(" ") }
        .forEach(::println)
    println("-------------------")
    val agePerSex = t.getCustomers()
        .filter { it.age > 0 }
        .groupBy({ it.sex }, { it.age })
        .mapValues { it.value.average() }
    println("Age moyen femmes: ${agePerSex[Sex.FEMALE]}")
    println("Age moyen hommes: ${agePerSex[Sex.MALE]}")
    println("-------------------")
    val agePerCategory = t.getCustomers().asSequence()
        .filter { it.age > 0 }
        .groupBy({ it.category() }, { it.age })
        .mapValues { it.value.average() }
    agePerCategory.forEach { (k, v) -> println("$k : $v") }
    println("-------------------")
    val countPerCategory = t.getCustomers()
        .filter { it.age > 0 }
        .groupBy { it.category() }
        .mapValues { it.value.size.toLong() }
    countPerCategory.forEach { (k, v) -> println("$k : $v") }
    println("-------------------")
    t.getCustomers().asSequence()
        .filter { it.age >= 18 &&
                it.pClass == 1 &&
                it.survived &&
                it.fullName()?.get(0).equals("Miss", ignoreCase = true) }
        .sortedBy { it.age }
        .forEach(::println)
}