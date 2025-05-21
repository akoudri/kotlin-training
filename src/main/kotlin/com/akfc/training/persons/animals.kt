package com.akfc.training.com.akfc.training.persons

sealed class Animal (val name : String, val age : Int) {
    abstract fun talk()

    abstract class Mammal(name: String, age: Int) : Animal(name, age)

    abstract class Bird(name: String, age: Int) : Animal(name, age)
}

class Dog(name: String, age: Int) : Animal.Mammal(name, age) {
    override fun talk() {
        bark()
    }

    private fun bark() {
        println("Ouaf Ouaf")
    }
}

fun main() {
    val dog = Dog("Woolfy", 12)
    dog.talk()
}