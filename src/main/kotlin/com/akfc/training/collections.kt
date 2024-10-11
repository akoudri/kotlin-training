package com.akfc.training.com.akfc.training

class Man(val name: String, val age: Int)

fun main() {
    val mens = mutableListOf<Man>()
    mens.add(Man("Michel", 32))
    mens.add(Man("Paul", 28))
    mens.add(Man("Joseph", 41))
    mens.add(Man("Michel", 45))
    mens.add(Man("Paul", 53))
    mens.add(Man("Albert", 41))
}
