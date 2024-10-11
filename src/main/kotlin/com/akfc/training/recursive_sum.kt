package com.akfc.training.com.akfc.training

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

fun main() {
    var total = 0L
    var start = System.currentTimeMillis()
    for (i in 0..1_000_000_000) {
        total += i
    }
    var duration = System.currentTimeMillis() - start
    println("$total computed in $duration ms")

    val pool = ForkJoinPool.commonPool()
    start = System.currentTimeMillis()
    total = pool.invoke(RecursiveSum(0, 1_000_000_000))
    duration = System.currentTimeMillis() - start
    pool.shutdown()
    println("$total computed in $duration ms")
}

class RecursiveSum(private val lo: Long, private val hi: Long) : RecursiveTask<Long>() {

    override fun compute(): Long {
        return if (hi - lo <= 1000) {
            var total = 0L
            for (i in lo..hi) {
                total += i
            }
            total
        } else {
            val mid = (hi + lo) / 2
            val left = RecursiveSum(lo, mid)
            val right = RecursiveSum(mid + 1, hi)
            left.fork()
            right.compute() + left.join()
        }
    }
}