package cn.awpaas.learn.day02

fun main(args: Array<String>) {
    /*
    Map 分为
        只读map Map
        可编辑Map MutableMap、 HashMap、 LinkedHashMap
     */

    // 创建一个只读的空map
    val readOnly = mapOf<String, Int>()
    println(readOnly.size)
    println(readOnly.isEmpty())

    val readOnly2 = emptyMap<String, Int>()
    // 这两种 是等价的
    println(readOnly == readOnly2)

    // 第二种创建map的方法
//    val readyOnly3 = mapOf(Pair("a", 1), Pair("b", 2))
    // 上面和下面的是等价的
    val readyOnly3 = mapOf( "a" to 2, "c" to 3)
    println(readyOnly3)

    // treeMap 的创建方式 之一 创建一个根据key升序排好的treeMap
    val treeMap = sortedMapOf(1 to "afterloe", 3 to "joe", 0 to "jakson")
    println(treeMap)

    // 循环
    treeMap.entries.forEach { println("key is ${it.key} value is ${it.value}")}
//    for (entry in treeMap.entries) {
//        println("key is ${it.key} value is ${it.value}")
//    }
}