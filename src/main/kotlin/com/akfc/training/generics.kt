package com.akfc.training.com.akfc.training

fun <T> display (value : T)
    where T : Number
{
    println(value)
}

// Interfaces avec variance
interface Producer<out T> {
    fun produce(): T
}

interface Consumer<in T> {
    fun consume(item: T)
}

// Hiérarchie de classes
abstract class Animal(val name: String)
abstract class Mammal(name: String) : Animal(name)
class Cat(name: String) : Mammal(name)
class Dog(name: String) : Mammal(name)

// Implémentations concrètes
class CatProducer : Producer<Cat> {
    override fun produce(): Cat = Cat(name = "Félix")
}

class AnimalConsumer : Consumer<Animal> {
    override fun consume(item: Animal) {
        println("Je consomme un animal nommé ${item.name}")
    }
}

fun main() {
    // Covariance : Producer<Cat> est un sous-type de Producer<Animal>
    val catProducer: Producer<Cat> = CatProducer()
    val animalProducer: Producer<Animal> = catProducer // OK grâce à 'out'
    val animal: Animal = animalProducer.produce()      // On récupère un Animal (en réalité un Cat)
    println("Animal produit : ${animal.name}")

    // Contravariance : Consumer<Animal> est un sous-type de Consumer<Cat>
    val animalConsumer: Consumer<Animal> = AnimalConsumer()
    val catConsumer: Consumer<Cat> = animalConsumer    // OK grâce à 'in'
    catConsumer.consume(Cat("Minette"))                // On consomme un Cat

}
