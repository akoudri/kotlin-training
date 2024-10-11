package com.akfc.training.com.akfc.training

data class Man(val name: String, val age: Int)

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}

class BinarySearchTree<T : Comparable<T>> {
    var root: Node<T>? = null

    fun insert(value: T) {
        TODO()
    }

    fun search(value: T): Boolean {
        TODO()
    }
}

fun main() {
    val mens = mutableListOf<Man>()
    mens.add(Man("Michel", 32))
    mens.add(Man("Paul", 28))
    mens.add(Man("Joseph", 41))
    mens.add(Man("Michel", 45))
    mens.add(Man("Paul", 53))
    mens.add(Man("Albert", 41))
}
