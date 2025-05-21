package com.akfc.training.com.akfc.training

/*sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}*/

interface Shape {

    fun area(): Double
}

open class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area() = width * height
}

class Square(size : Double) : Rectangle(size, size)

class Circle(val radius: Double) : Shape {
    override fun area() = Math.PI * radius * radius
}

fun main() {
    val shapes = listOf(
        Circle(10.0),
        Rectangle(5.0, 10.0),
        Square(5.0),
        Square(5.0)
    )

    shapes.forEach { println(it.area()) }
}
