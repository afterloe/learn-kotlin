package cn.awpaas.learn.day03

/*
枚举类
 */
enum class Language {
    Java, Kotlin, Go, R
}

enum class Color(val rgb: Number) {
    Red(0xFF0000),
    Green(0x00FF00),
    Blue(0X0000FF)
}

fun main(args: Array<String>) {
    // 每一个enum 都有两种属性 -》 name 名称、ordinal 位置
    val that = Language.Java
    println("we are Learning $that, item is ${that.ordinal}")

    val color = Color.Blue
    println("switch color is $color, RGB is ${color.rgb}")

    // enum 循环 或者合并输出
    println(enumValues<Color>().joinToString { "${it.rgb}:${it.name}:${it.ordinal}" })
}