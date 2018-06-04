package cn.awpaas.learn.day02

/**
 * 强swatch case =》 when 的实现逻辑
 */
fun whenInfo(x :Any) {
    when(x) {
        1 -> println("input value is $x")
        true -> println("input value is true..")
        is String -> println("input value is string ...")
        else -> println("what ary you input about?")
    }
}

fun main(args: Array<String>) {
    var x :Any = 320
    whenInfo(x)
    x = "info"
    whenInfo(x)
}