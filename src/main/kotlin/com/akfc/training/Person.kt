package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker

class Person(var name: String?, val age: Int) {

    var weight = 0.0
    companion object {
        val faker = Faker.instance()
    }

    val fullName: String
        get() = "$name $age"

    init {
        if (name == null) name = faker.name().fullName()
        require(age >= 0) { "Age cannot be negative" }
    }

    constructor(name: String, age: Int, weight: Double) : this(name, age) {
        this.weight = weight
    }

    fun isAdult() = age >= 18

    override fun toString() : String {
        return "Person $name with age $age"
    }
}

