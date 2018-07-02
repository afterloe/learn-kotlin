package cn.awpaas.learn.day02

fun main(args: Array<String>) {
    val list: List<Int> = listOf() // 创建一个空的list
    println(list.size)

    // val list: List<Int> = listOf(10) // 创建一个长度为10的list
    // val list: List<Int> = listOf(1,23,4,5,5) // 创建有内容的list
    // val list= arrayListOf(0,1,2,3,4) | listOf(0,1,2,3,4)

    /*
        创建可变集合 MutableList
     */
    val list1 = mutableListOf(1,2,3)
    println(list1::class)
//    list1.addAll(2, list)
//    list.toMutableList() // 也可以用这种方式将list 转换为 mutableList


}