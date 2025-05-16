package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker

class Group {

    companion object {
        val faker = Faker.instance()
    }

    val persons : Array<Person> = Array(10) { Person(faker.name().fullName()) }
    var count = 0

    inner class Person(val name: String) {
        init {
            this@Group.count++
        }
    }
}

fun main() {
    val group = Group()
    println(group.count)
}