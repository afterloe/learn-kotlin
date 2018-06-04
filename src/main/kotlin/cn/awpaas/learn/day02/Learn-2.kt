package cn.awpaas.learn.day02

import java.util.Random

// 带 return 的 调用的时候不用 invoke
fun toList(r :Int): Array<Int> {
    val rand = Random()
    val target: Array<Int> = Array(r, {0})
    var i = 0
    while (i < r) {
        target.set(i, rand.nextInt())
        i++
    }
    return target
}

// 不带return的 lambda 需要调用invoke来完成
fun maxValue(x :Array<Int>) = {
    var max = 0
    // 第一种写法
    /*
    for ((index, value) in x.withIndex()) {

    }
    */
    // 第二种写法
    /*
    for (i in x.indices) {

    }
    */
    // 第三种写法
    for (i in x) {
        max = if (max > i) max else i
    }

    max
}

fun main(args: Array<String>) {
    val intArray = arrayOf(1,10,3,12,56,23,13,6,5)
    println("input max value is ${maxValue(intArray).invoke()}")
    println("random max value is ${maxValue(toList(10)).invoke()}")
}