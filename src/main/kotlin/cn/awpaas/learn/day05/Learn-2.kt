package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*


/**
 * 更加优雅的携程调度方式
 *
 * 如果main函数 不添加 runBlocking 是不能通过delay 来完成柱塞的
 * runBlocking 设计目的主要是用来桥接普通阻塞代码和 挂起风格的非阻塞代码
 * 例如 main函数 或 junit4 中的测试用例
 */
fun main(args: Array<String>) = runBlocking {
    // 主协程
    println("${Date()} T0")

    // 启动子协程
    launch {
        println("${Date()} T1")
        delay(3000L) // 休眠 - 默认时间单位是 毫秒
        println("${Date()} T2 -> hello, ")
    }
    println("${Date()} T3 -> afterloe!") // 当子协程 休眠的时候 主协程仍然运行
    delay(5000L)
    println("${Date()} T4")
}