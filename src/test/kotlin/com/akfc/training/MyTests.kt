package com.akfc.training

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyTests {

    @Test
    fun testMultiplication() {
        val result = 2 * 3
        assertEquals(6, result)
    }

    @Test
    fun testDivision() {
        val result = 6 / 2
        assertEquals(3, result)
    }
}