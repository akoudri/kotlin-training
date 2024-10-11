package com.akfc.training.com.akfc.training

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Repeatable
annotation class TestCase(
    val testName: String,
    val priority: Int = 0,
    val tags: Array<String> = [],
    val expectedExceptions: Array<KClass<out Throwable>> = []
)

@TestCase(testName = "Test 1", priority = 1, tags = ["unit", "fast"])
fun test1() {
    println("Test 1")
}

fun runTests(testClass: Any) {
    val kClass = testClass::class
    val testMethods = kClass.members
        .filter { it.annotations.any { ann -> ann is TestCase } }

    testMethods.sortedBy {
        it.annotations.filterIsInstance<TestCase>().first().priority
    }
        .forEach { method ->
            val testCase = method.annotations.filterIsInstance<TestCase>().first()
            println("Running test: ${testCase.testName}")
            try {
                method.call(testClass)
                println("Test passed")
            } catch (e: AssertionError) {
                println("Test failed: ${e.message}")
            }
            println("---")
        }
}

fun main() {
    runTests(test1())
}

