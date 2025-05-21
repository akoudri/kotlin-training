import com.akfc.training.com.akfc.training.Rectangle
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

fun displayClassInfo(clazz: KClass<*>) {
    println("Class: ${clazz.simpleName}")
    // Display properties
    println("Properties:")
    clazz.declaredMemberProperties.forEach { property ->
        println("- ${property.name}: ${property.returnType}")
    }
}

fun main() {
    // Get the class objec  t for Rectangle
    val rectangleClass = Rectangle::class
    // Display properties and methods of Rectangle
    displayClassInfo(rectangleClass)
}