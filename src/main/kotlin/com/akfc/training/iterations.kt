package com.akfc.training.com.akfc.training

fun main() {

    val fruits = mutableListOf("Pomme", "Banane", "Cerise")

    for (fruit in fruits) {
        println(fruit)
    }

    for (i in fruits.indices) {
        println("Index $i : ${fruits[i]}")
    }

    val iterator = fruits.iterator()
    while (iterator.hasNext()) {
        val fruit = iterator.next()
        println(fruit)
        if (fruit.startsWith("B")) {
            iterator.remove() // possible avec un MutableIterator
        }
    }

    fruits.forEach { fruit ->
        println(fruit)
    }

    fruits.forEachIndexed { index, fruit ->
        println("Fruit $index : $fruit")
    }

    val listIterator = fruits.listIterator()
    while (listIterator.hasNext()) {
        println(listIterator.next())
    }
    while (listIterator.hasPrevious()) {
        println(listIterator.previous())
    }

}

