package com.akfc.training.com.akfc.training

class Person(val name: String, val age: Int) {

    var weight = 0.0

    val fullName: String
        get() = "$name $age"

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(age >= 0) { "Age cannot be negative" }
    }

    constructor(name: String, age: Int, weight: Double) : this(name, age) {
        this.weight = weight
    }

    fun isAdult() = age >= 18
}

