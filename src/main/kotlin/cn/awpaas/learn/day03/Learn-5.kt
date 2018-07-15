package cn.awpaas.learn.day03

import kotlin.reflect.KProperty

/*
    委托的骚操作
 */

// 代理模式 函数代理
interface Loop {
    fun read()
    fun write()
}

class ReadEvent: Loop {
    override fun read() {
        println("read loop")
    }

    override fun write() {
        println("write loop")
    }
}

class EventProxy(var loop: Loop): Loop by loop {

    // 前后环绕
    override fun read() {
        println("afterloe begin")
        loop.read()
        println("afterloe end")
    }
}

/*
属性 委托
 */
class File() {
    var name: String by FileContext()

    override fun toString(): String {
        return "File info"
    }
}

class FileContext() {

    operator fun getValue(file: File, property: KProperty<*>): String {
        println("get value ... ${property.name}")
        return property.name
    }

    operator fun setValue(file: File, property: KProperty<*>, s: String) {
        println("set value ... $s")
    }
}

fun main(args: Array<String>) {

    // 类的委托
    val readEvent = ReadEvent()
    val proxy = EventProxy(readEvent)
    proxy.read()

    // 属性委托
    val doc = File()
    doc.name = "七里香"
    doc.name = "秋刀鱼"
    println(doc.name)
}