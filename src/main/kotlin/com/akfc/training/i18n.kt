package com.akfc.training.com.akfc.training

import java.util.Locale
import java.util.ResourceBundle
import java.text.MessageFormat

fun main() {
    val locales = listOf(
        Locale.Builder().setLanguage("en").setRegion("US").build(),
        Locale.Builder().setLanguage("fr").setRegion("FR").build()
    )

    val firstName = "John"
    val lastName = "Doe"

    for (locale in locales) {
        val bundle = ResourceBundle.getBundle("Message", locale)
        val pattern = bundle.getString("greeting") // Assuming "greeting" is the key in your resource bundle
        println("Locale: ${locale.displayName}")
        println("Greeting: ${MessageFormat.format(pattern, firstName, lastName)}")
        println()
    }
}