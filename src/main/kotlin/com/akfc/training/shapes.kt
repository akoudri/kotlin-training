package com.akfc.training.com.akfc.training

/*sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}*/

interface Shape {

    abstract fun area(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area() = width * height
}

class Square(val rect: Rectangle) : Shape by rect {
    constructor(side: Double) : this(Rectangle(side, side))

    override fun area() = rect.area()
}

class Circle(val radius: Double) : Shape {
    override fun area() = Math.PI * radius * radius
}

fun main() {
    val shapes = listOf(
        Circle(10.0),
        Rectangle(5.0, 10.0),
        Square(5.0)
    )

    shapes.forEach { println(it.area()) }
}
