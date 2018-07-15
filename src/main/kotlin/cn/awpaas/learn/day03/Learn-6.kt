package cn.awpaas.learn.day03

/*
延迟加载， 使用lazy关键字来标识, 他接收一个lambda表到时，返回一个Lazy实例
 */
fun main(args: Array<String>) {
    // 默认的是 同步的
    val synchronizedLazy = lazy {
        // 延迟加载
        println("--- 3")
        println("--- 2")
        println("--- 1")

        "Hello world - afterloe"
    }
    val v1 :String by synchronizedLazy
    println(v1)
    println(v1)

    val v2 :String by lazy {
        println("---- 3")
        println("---- 2")
        println("---- 1")

        "Hello world - joe"
    }
    println(v2)
    println(v2)

    // 这种和上面是等价的
    val v3 :String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        "Hello world - daniel"
    }
    println(v3)

    // LazyThreadSafetyMode.PUBLICATION 多个线程同时执行
    // LazyThreadSafetyMode.NONE 单线程，效率最高
}