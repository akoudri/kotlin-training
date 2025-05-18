package com.akfc.training.com.akfc.training

class Personne() {
    var nom : String = ""
    var age : Int = 0
}

fun main() {
    var name: String? = "Alice"
    //val longueur = name?.let { it.length }
    //println("longueur = $longueur")

    val liste = mutableListOf(1, 2, 3)
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
    val vide = input2.takeUnless { it.isNotEmpty() } // "" ou null


}