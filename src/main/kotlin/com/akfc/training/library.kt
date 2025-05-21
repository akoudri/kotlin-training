package com.akfc.training.com.akfc.training

import com.github.javafaker.Faker
import java.util.Date

data class Book(val title: String, val author: String, val publisher: String)

class Library {
    val books = arrayListOf<Book>()

    init {
        val faker = Faker()
        (1..100).asSequence()
            .map { faker.book() }
            .map { Book(it.title(), it.author(), it.publisher()) }
            .forEach { books.add(it) }
    }

    fun addBook(book: Book) {
        val b = book.copy()
        if (! books.contains(book)) books.add(book)
    }
}

fun main() {
    val lib = Library()
    lib.books.slice(1..5).forEach { println(it) }
}