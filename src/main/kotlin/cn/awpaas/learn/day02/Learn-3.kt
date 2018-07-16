package cn.awpaas.learn.day02

open class Animal(val name: String) {
    open fun sound() {
        println("my name is ${this.name}")
    }

    fun hoho() {
        println("吼吼吼...")
    }
}

class Dog(name: String): Animal(name) {
    override fun sound() {
        println("i'm a dog, my name is ${this.name}")
    }
}

fun main(args: Array<String>) {
//   println(null == null) // true
//   println(null != null) // false
//   println(null is Any?) // true // null 是 any？类型，在kotlin里面，使用is来判断类型

    /* ?. 安全调用 !!. 非空断言调用
     * 如果不需要捕获异常来处理，可以使用安全调用符
     */
    fun getLength(str: String?): Int? = str?.length

    println(getLength(null)) // null
    println(3 == getLength("abc")) // true

    /*
     * 出现空指针异常的，就要使用非空断言
     */
//    fun getLength2(str: String?): Int? = str!!.length
//    println(getLength2(null)) // throw KotlinNullPointerException

    val target = Animal("target")
    val blank = Dog("blank")

    println(target.sound())
    println(blank.sound())
    // as 直接转型 相当于强制类型转换
    println((target as? Dog)) // 如果转型失败会显示null
    println((blank as Animal).hoho())
}