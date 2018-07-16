package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit

// 协程的 简单实例
fun firstDemo() {
    launch(CommonPool) {
        delay(3000L, TimeUnit.MILLISECONDS)
        println("Hello, ")
    }
    println("afterloe !")
    Thread.sleep(5000L)
}

fun main(args: Array<String>) {
    firstDemo()
}