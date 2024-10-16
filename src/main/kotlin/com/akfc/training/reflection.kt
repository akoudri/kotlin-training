import com.akfc.training.com.akfc.training.Rectangle
import kotlin.reflect.full.declaredMemberProperties

fun displayClassInfo(clazz: Class<*>) {
    println("Class: ${clazz.simpleName}")
    // Display properties
    println("Properties:")
    clazz.kotlin.declaredMemberProperties.forEach { property ->
        println("- ${property.name}: ${property.returnType}")
    }
    clazz.superclass.let { println(it.simpleName) }
    clazz.interfaces.forEach { println(it.simpleName) }
}

/*
fun main() {
    // Get the class object for Rectangle
    val rectangleClass = Rectangle::class.java
    // Display properties and methods of Rectangle
    displayClassInfo(rectangleClass)
}*/
