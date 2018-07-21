package cn.awpaas.learn.day05

import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.runBlocking

/**
 * 使用channel 作为生产者
 */
val produceSquares = produce<Int> {
    for (x in 1..7) send(x)
}

/**
 * 作为消费者 进行监听消费
 */
val consumeSquares = runBlocking {
    val squares = produceSquares
    squares.consumeEach {
        println("consumer $it")
    }
    println("Done")
}

fun main(args: Array<String>) {
    consumeSquares
}