package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker

class Personne() {
    var nom : String = ""
    var age : Int = 0
}

data class User(
    var name : String? = null,
    var email : String? = null,
    var age : Int = 0,
    var isActive : Boolean = false
)

fun doStuff() : Int {
    TODO("Function not implemented")
}

fun main() {
    val faker = Faker()
    val user = User().apply {
        name = faker.name().fullName()
        email = "${name}@${faker.company().name()}.com".replace(" ", ".")
        age = 42
        isActive = true
    }
        .also { println(it) }
        .run { check(age > 30) }

    //val x =     doStuff()
    val l = mutableListOf<Int>(1, 2 , 3)
    l.apply { add(5) }.also { println(it) }
    //var name: String? = "Alice"
    //val longueur = name?.let { it.length }
    //println("longueur = $longueur")

    /*val liste = mutableListOf(1, 2, 3)
        .also { println("Avant ajout : $it") }
        .apply { add(4) }
        .also { println("Après ajout : $it") }

    val personne = Personne().apply {
        nom = "Bob"
        age = 30
    }

    val longueur = "Kotlin".run { length * 2 }

    val sb = StringBuilder()
    val result = with(sb) {
        append("Hello, ")
        append("world!")
        toString()
    }

    val input1 = "Kotlin"
    val nonVide = input1.takeIf { it.isNotEmpty() } // "Kotlin" ou null

    val input2 = ""
    val vide = input2.takeUnless { it.isNotEmpty() } // "" ou null*/


}