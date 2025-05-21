package com.akfc.training.com.akfc.training.persons

enum class Day(val isSchoolDay : Boolean = false) {
    MONDAY,
    TUESDAY,
    WEDNESDAY(true);

    fun foo() {
        println("Foo ${this.ordinal} ${this.name}")
    }
}

data class Man(var firstname: String = "Toto", var lastname: String = "Tata")

data class Car(val model: String, val color: String, val year: Int) {
    constructor(model: String, year: Int): this(model, "white", year)
    constructor(model: String): this(model, 2024)
}