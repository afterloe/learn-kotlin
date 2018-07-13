package cn.awpaas.learn.day03

/*
类的基本用法
 */
class Dog(name: String) {
    // 多构造函数的使用与申明
    constructor() : this("嘿嘿"){
    }
}

/*
私有构造函数

同时申明公开访问权限的对象
 */
class MyDog private constructor(var name: String, age: Number) {

    // 类似于 static
    companion object {

        // 函数初始值
        fun buyDoy(name: String = "黑黑", age: Number = 0.3): MyDog = MyDog(name, age)
    }

    fun say(): String = "汪汪汪"
}

/*
抽象类

抽象函数必须使用abstract修饰
抽象函数不必手动添加open 自己自带
抽象函数必须为 public 或者 protected, 默认为public
 */
abstract class Computer {
    // 抽象属性
    abstract val name: String
    // 抽象方法
    protected abstract fun run(): String

    // 普通函数
    fun exec() {

    }
//    子类实现是默认添加final的，如果想要重写需要手动添加open
//     open 代表允许重写
    open fun open() {
        println("超类计算机")
    }
}

class Mac(override val name: String) : Computer() {
    override fun run(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun open() {

    }

}

fun main(args: Array<String>) {
    val dog1 = MyDog.buyDoy("拐子兵")
    println(dog1.name) // 自带getter
    println(dog1.say())
    dog1.name = "嗷大喵" // 自带setter
    println(dog1.name)
}
