package com.akfc.training.com.akfc.training

enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

enum class Color(val rgb: Int) {
    RED(0xFF0000) {
        override fun print() { println("This is red") }
    },
    GREEN(0x00FF00) {
        override fun print() { println("This is green") }
    };

    abstract fun print()
}
