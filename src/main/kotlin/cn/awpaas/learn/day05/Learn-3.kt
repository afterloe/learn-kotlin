package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/*
等待协程

场景： 比如进行一个异步操作，需要等待异步操作的结果 进行 reduce。
 */
// 两种 suspend 函数， 他是不能传入参数的
val job = suspend {
    println("job 1: started")
    println("job 1: hello, ->${Thread.currentThread()}")
    delay(3000L)
    println("job 1: is complete.")
}

suspend fun job2() {
    println("job 2: started")
    println("job 2: hello, ->${Thread.currentThread()}")
    delay(5000L)
    println("job 2: is complete.")
}

fun waitToComplete() = runBlocking {
    val son1 = launch { job() }
    val son2 = launch { job2() }
    println("hi!")
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
    son1.join()
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
    son2.join()
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
}

fun main(args: Array<String>) {
    // 运行协程函数
    waitToComplete()
}