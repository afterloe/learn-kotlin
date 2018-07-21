package cn.awpaas.learn.day04

// 使用括号 来申明一个函数定义， 同时也可以 返回一个函数
fun triple(f1: (Int) -> Int): (Int) -> Int = { x -> f1(x) + x }

class A_temper {
    fun double(x: Int):Int = 2 * x
}

// 可以在不继承 对象的情况下 进行扩展
fun A_temper.link(x: Int): Int {
    // 使用this来指定扩展函数内部对应到的接受者
    return this.double(x + 1)
}

// 中辍函数
infix fun A_temper.remote(x: Int): Int = this.double(x + 2)

fun main(args: Array<String>) {
    // 函数传递
    // 先申明一个函数 字面量
    val dub = fun(x: Int): Int = 2 * x
    val value = triple(dub)(10)
    println(value)

    // 函数扩展的使用
    val d = A_temper()
    println(d.double(4))
    println(d.link(4))

    // 中辍函数的运用 - 相当于换一个 调度方式 等同于 d.remote(4)
    val d1 = d remote 4
    println(d1)
}