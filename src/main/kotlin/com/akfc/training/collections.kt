package com.akfc.training.com.akfc.training

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}

class BinarySearchTree<T : Comparable<T>> {
    var root: Node<T>? = null

    fun insert(value: T) {
        root = insertRecursive(root, value)
    }

    private fun insertRecursive(current: Node<T>?, value: T): Node<T> {
        if (current == null) {
            return Node(value)
        }

        if (value < current.data) {
            current.left = insertRecursive(current.left, value)
        } else if (value > current.data) {
            current.right = insertRecursive(current.right, value)
        }

        return current
    }

    fun search(value: T): Boolean {
        return searchRecursive(root, value)
    }

    private fun searchRecursive(current: Node<T>?, value: T): Boolean {
        if (current == null) {
            return false
        }
        if (value == current.data) {
            return true
        }
        return if (value < current.data) {
            searchRecursive(current.left, value)
        } else {
            searchRecursive(current.right, value)
        }
    }
}

data class Man(val name: String, val age: Int) : Comparable<Man> {
    override fun compareTo(other: Man): Int {
        // Compare by age first, then by name if ages are equal
        return compareValuesBy(this, other, { it.age }, { it.name })
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

    // Sort by age and then by name
    val sortedByAgeAndName = mens.sortedWith(compareBy<Man> { it.age }.thenBy { it.name })
    println("Sorted by age and name:")
    sortedByAgeAndName.forEach { println(it) }

    // List all men whose age is above 41
    val menAbove41 = mens.filter { it.age > 41 }
    println("\nMen with age above 41:")
    menAbove41.forEach { println(it) }

    // List all men whose age is between 28 and 41 (inclusive)
    val menBetween28And41 = mens.filter { it.age in 28..41 }
    println("\nMen with age between 28 and 41:")
    menBetween28And41.forEach { println(it) }

    //Use BST to search
    val bst = BinarySearchTree<Man>()

    // Insert men into the BST
    mens.forEach { bst.insert(it) }

    // Search for a specific man
    val manToFind = Man("Joseph", 41)
    val found = bst.search(manToFind)

    println("Is $manToFind found? $found")
}
