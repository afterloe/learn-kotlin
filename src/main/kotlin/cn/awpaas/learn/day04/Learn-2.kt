package cn.awpaas.learn.day04

/*
函数参数
函数 - 使用pascal表示法定义，即 name:type 参数用逗号隔开，显示的指定类型
 */

// 默认值 - 可以减少重载数量 这种形式也称为单表达形式
fun add(x :Number = 0, y :Number = 0): Number  = x.toInt() + y.toInt()

// 可变参数 -- 使用 vararg 作为标志 实质上是实现了 iterator 的类
fun add1(vararg ts: Int): Int = ts.fold(0) {total, any -> any + total}

// lambda 定义参数 lambda 表达式总是被大括号扩者，而且使用 -> 表达函数体
// it 是默认参数
val sum = { x: Int, y: Int -> x + y }

data class ResponseDTO(var data: String) {
    fun body() {
        println(data)
    }
}

// 带接收者的函数字面值 这里 ResponseDTO.() 就是接受者类型
fun responseDTO(init: ResponseDTO.() -> Unit): ResponseDTO {
    val html = ResponseDTO("this is body") // 创建接受者
    html.init() // 将该接收者传给该 lambda
    return html
}

// 内联函数 支持 具体化类型参数 内联函数需要使用 reified 关键字来修饰类型
//inline fun <reified T> TreeNode.findParentOfType(): T? {
//    var p = parent
//    while (p != null && p !is T) {
//        p = p.patent
//    }
//    return p as T?
//}

// 调用
// treeNode.findParentOfType<MyTreeNode>()

// 尾递归函数
// 优化递归，防栈益处，同时优化，产生一个高速并且搞笑的代码
tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

fun main(args: Array<String>) {
    println("2 + 2 = ${add(2, 2)}")

    // 命名参数 - 当函数存在默认值的时候可以如下使用
    println("4 + 4 = ${add(y = 4)}") // 只传递需要的参数
    println("4 + 4 + 4 + 4 = ${add1(4, 4, 4, 4)}")
    println("5 + 5 = ${sum(5, 5)}")

    // 按照类型自动处理函数
    responseDTO{body()}
    println(findFixPoint())
}