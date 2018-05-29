package cn.awpaas.learn.day01

val des = arrayOf("1", "5", "8")
val asc = Array(5, {i -> (i + i).toString()})

// 多行文本
val text = """
   for (c in "foo") {
    print(c)
   }
"""

val text1 = """
    # afterloe
    # joe
    # gradle
""".trimMargin("#")

fun toString(a : Array<*>) {
    val it = a.iterator()
    while (it.hasNext()) {
        print("${it.next()},")
    }
//    println("")
}

fun main(args: Array<String>) {
    println(toString(des))
    println(toString(asc))
    println(text)
    println(text1)
}