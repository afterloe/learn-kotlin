package cn.awpaas.learn.day02

fun main(args: Array<String>) {
    /*
    set 不可变， 不重复集合
    mutableSet 可变，不重复集合
     */
    val emptySet = emptySet<Int>() // 创建一个空的set 集合
    println(emptySet.isEmpty()) //true
    println(emptySet.size) // 0
    println(emptySet.hashCode()) // 0 - 输出hashCode

    // 创建一个含有初始值的set
    val set1 = setOf(1, 2, 3, 4, 1)
    val set2 = mutableSetOf("a", "b", "c", "a")
    println(set1) // 1,2,3,4
    println(set2) // a,b,c

    println(set2 + "r") // 和 plush 函数功能一致 [a, b, c, r]
    println(set2 - "a") // 和 minus 函数功能一致 [b, c]
}