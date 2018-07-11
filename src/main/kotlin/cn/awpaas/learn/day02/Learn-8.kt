package cn.awpaas.learn.day02

fun main(args: Array<String>) {
    /*
    map 相关读写操作
     */
    val map = mutableMapOf(1 to "afterloe", 2 to "joe", 3 to "grace", 4 to "niko", 5 to "daniel")
    println(map)

    // 判断key是不是在map之中
    println("the key 3 is in this map? ${map.containsKey(3)}")

    // 判断value 是不是在map之中
    println("the vale afterloe is in this map? ${map.containsValue("afterloe")}")

    // 操作map entry函数
    // component1 -> key ; component2 -> value
    map.entries.forEach { println("key=${it.component1()}, value=${it.component2()}") }

    // 可以把map里面的entry 转换为 pair 的函数
    map.entries.forEach { println(it.toPair()) } // 直接调用
    println(map.getOrElse(6) {"salden"}) // 获取map中的值, 不存在就获取默认值
    // get获取如果key 不存在会得到null 如果使用getValue，不存在会抛出异常

    println(map.getOrPut(6) {"salden"}) // 获取map中对应的key的值，如果不存在就put进去

    // map 实现了 iterator 接口, 可以使用forEach来循环
//    for ((k, v) in map) { println("key -> $k, value -> $v") }

    // 过滤
    println(map.filterKeys { it % 2 == 0 }) // 过滤出 偶数的key
    println(map.filterValues { it.startsWith("jo") }) // 过滤出 以jo 开头的value
    println(map.filter { it.key > 3 && -1 != it.value.indexOf("o") }) // 输出key 大于3 并且包含o的map 集合
    // map 也是可以由 Pair的队列生成的, 其他的用法都类似于 java中的用法

}