package com.akfc.training.com.akfc.training

interface Vehicle {
    companion object {
        const val WHEELS = 4
        @JvmStatic fun factory(): Vehicle = Car()
    }

    fun drive()
}

interface Medium {
    fun transport() {
        println("Transporting people")
    }
}

class Car : Vehicle, Medium {
    override fun drive() {
        println("Driving a car")
    }
}

