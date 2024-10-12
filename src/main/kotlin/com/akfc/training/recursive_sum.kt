package com.akfc.training.com.akfc.training

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

fun main() {
    var total = 0L
    for (i in 0..1_000_000_000) {
        total += i
    }

    val pool = ForkJoinPool.commonPool()
    total = pool.invoke(RecursiveSum(0, 1_000_000_000))
    pool.shutdown()
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