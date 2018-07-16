package cn.awpaas.learn.day02

/**
 *  过滤是最常进行的操作，那么列举下可能用到的几种常规 过滤操作函数
 */
fun toStr(list: List<Any>): String = list.reduce { total, any -> total.toString() + any.toString() }.toString()

fun main(args: Array<String>) {
    var list = mutableListOf<Any>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // 获取前几个元素
    println("the 3 first element of collections -> ${toStr(list.take(3))}")

    var list1 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    // 条件获取

    val chars = (1..10).toList()
    println(chars.take(3)) // 1,2,3
    println(chars.takeWhile { it%2 == 0 }) // 2,4,6,8,10
    println(chars.takeLast(2)) // 9,10
    println(chars.takeLastWhile { it > 7 }) // 7,8,9,10

//    println("the even number collections -> ${toString(list1.takeWhile { any -> any % 2 == 0})}")

    var list2 = mutableListOf(1,2,3,4,5,6)
    var list3 = mutableListOf("a", "b", "c", "d")
    // [(1, a), (2, b), (3, c), (4, d)]
    var info = list2.zip(list3) // 将两个集合按照下标进行匹配，并返回，如果两个集合长度不一致，按照短的集合长度
//    var listPair = mutableListOf(Pair(1,2), Pair(3,4), Pair(5,6), Pair(7,8))
    println(info)
    println(info.get(1))
    println(info.unzip())

    // 也可以进行格式的转换和处理
    println(list3.zip(list2) { t1, t2 -> t1 + t2})

    // 按照条件进行拆分
    println(list1.partition { it > 5 })
    // add all 相当于
    println(list1.plus(list2))
}

