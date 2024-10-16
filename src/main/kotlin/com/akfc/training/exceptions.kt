package com.akfc.training.com.akfc.training

class InvalidUserInputException(message: String) : Exception(message)

fun getInput(): String {
    val userInput = " "
    if (userInput.isBlank()) {
        throw InvalidUserInputException("User input cannot be blank")
    }
    return userInput
}

/*fun main() {
    try {
        getInput()
    } catch (e: InvalidUserInputException) {
        println(e.message)
    } finally {
        println("Program finished")
    }
}*/

