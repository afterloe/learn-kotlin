package cn.awpaas.learn.day03

// 数据类 - pojo 或 dto 的使用
// 数据类使用 data 开头 必须添加 var 或者val
data class Phone(var name: String, var version: String)
// 允许 带有方法，1.1 之前只能实现接口
data class Phone1(
        val name: String,
        val tel: Number,
        val owner: Phone
) {
    fun validate(): Boolean = "true" === name
}

class Outer(var name: String) {
    // 内部类 是可以访问外部类的变量
    inner class inner {
        fun printer() {
            println("$name is inner")
        }
    }

    fun print1() {
        // 写法1
//        val wait = Runnable {
//            println("is no name runner")
//        }

        // lambda 写法
        val wait = {
            println("is no name runner")
        }

        Thread(wait).start()

        // 直接写
//        Thread {
//            println("第二种写法")
//        }.start()


    }
}

fun main(args: Array<String>) {

    // 结构、解构
    val phone = Phone("honor", "v9")
    val (name) = phone
    println("phone name is $name")

    // Pair（二元组）Triple （三元组） 都是标准的数据类

    // 内部类的访问也是同嵌套类一样 一层一层的引用
    val ou = Outer("aftreloe")
    ou.inner().printer()
    ou.print1()

    // 匿名内部类的运用
}