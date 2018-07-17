package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.*

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
    val son1 = launch {
        job()
        // 如果suspend 函数中正在进行循环操作，调用cancel 取消协程，isActive虽然为false， 但是循环中的代码是继续运行的

        // 处理方式一:
        /*
         while(true) {
            if (!isActive) {
                return@launch
            }
         }
         */
//        if (!isActive) return@launch

        // 处理方式二：
        // 直接调度yield 函数，他是捕获 isCompleted, 如果 isCompleted 返回true，循环的时候自动抛出异常 达到终止循环的操作
//        yield()
    }
    val son2 = launch {
        job2()
        // run 与 NonCancellable 结合，这里面的代码块是一定不会被取消的
        run(NonCancellable) {
            println("123 -> ")
        }
        // 设置协程超时时间，如果超过时间 抛出异常终止
        withTimeout(3000L) {
            println("toDo")
        }
    }
    println("hi!")
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
    son1.join()
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
    son2.join()
//    son1.cancel() // 取消协程 isActive 为true 并且 isCompleted 为false 的时候取消协程 返回是否成功的flag
    println("son1 is active? -> ${son1.isActive}; complete? -> ${son1.isCompleted}")
    println("son2 is active? -> ${son2.isActive}; complete? -> ${son2.isCompleted}")
}

fun main(args: Array<String>) {
    // 运行协程函数
    waitToComplete()
}