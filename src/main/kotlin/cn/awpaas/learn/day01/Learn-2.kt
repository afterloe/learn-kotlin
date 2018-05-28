package cn.awpaas.learn.day01

/**
 * Double, Float, Long, Int, Short, Byte
 * 64, 32, 64, 32, 16, 8
 */
// val 基本是常量了
val l = 1_000 // 直接描述 1000
val b: Byte = 1 // 类型申明
val i: Int = b.toInt() // 强转， number 可以使用 toByte(), toShort() ...

// 这个是变量 使用, 配合默认值
var a: Int ?= 844

fun main(args: Array<String>) {
    print("$a \n")
    println("to use $l -> $i")
    a = 1844
    println("$a")
}