package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

suspend fun job3(): Int {
    delay(4000)
    println("job2 Done ...")
    return 200
}

suspend fun job4(): Int {
    delay(3000)
    println("job1 Done ...")
    return 300
}

// 默认是同步执行的
fun main(args: Array<String>) = runBlocking {

    // 计算执行时间 - 同步执行
    val time1 = measureTimeMillis {
        val value1=  job3()
        val value2 = job4()
        println("info is over .. this sum is = ${value1 + value2}")
    }

    // 计算执行时间 - 异步执行 取最长时间
    val time2 = measureTimeMillis {
        // Deferred 是继承于Job 同样支持join 等操作
        val value1 = async { job3() }
        val value2 = async { job4() }

        println("info is over .. this sum is = ${value1.await() + value2.await()}")
    }

    println("[main] completed $time1 ms")
    println("[main] completed $time2 ms")
}
