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

    val intArr_1 = toList(11)
    println("init array ...")
    // 非lambda 调用，这里的 return 相当于 break
    intArr_1.forEach ( fun (a: Int) {
        if (a > 0) return
        print("\t $a")
    } )
    print("\n")
    println("init array ... lambda")
    // lambda 调用，这里的 return 相当于 continue
    intArr_1.forEach {
        if (it > 0) return
        print("\t $it")
    }

//    val arr_empt = arrayOfNulls<Int>( 10) // 创建一个长度为10的空int数组

}