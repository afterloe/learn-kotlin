package cn.awpaas.learn.day03

/*
kotlin 里面的 接口使用
 */
interface GetInfo {
    // 不同的是，他可以包含属性
    val method: String
    fun run()

    // 还可以包含方法
    fun exec() {
        println("to do something")
    }
}

// 接口实现. 添加open 在class 表示该类能够被继承
open class HttpGet: GetInfo {
    // 除了直接复制 还有这种骚操作
    override val method: String
        get() = "HttpGet implement"
//        set(value) = ...

    override fun run() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // override 前面添加final 表示该函数 不会被子类重写
    final override fun exec() {
//        super<GetInfo>.exec()  // 使用这种方法来解决 多重覆盖的问题
        // 覆盖重写
    }
}