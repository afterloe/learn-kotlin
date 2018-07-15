package cn.awpaas.learn.day03

import kotlin.properties.Delegates

// 变更属性触发器
class Computer1() {
    // 可观察属性委托
    var name: String by Delegates.observable("") {
        _, oldValue, newValue -> println("oldValue is $oldValue -> newValue is $newValue")
    }

    // 可否决属性委托 如果返回true 则表示可以修改， 返回false 则表示不可以修改
    var version: String by Delegates.vetoable("") {
        _, old, new -> new.length > old.length
    }

    // 非空属性委托 如果设置为空 直接报错
    var owner by Delegates.notNull<String>()
}

// map 映射属性 - var 属性表示可修改 需要传入的是 MutableMap等可以修改的map， 如果是val属性可以map
data class Account(val map: MutableMap<String, Any?>) {
    var name: String by map
    var password: String by map
}

fun main(args: Array<String>) {
    val mac = Computer1()
    mac.name = "mac A107"
    mac.name = "mac B103"
    mac.version = "ascs"
    println(mac.version)
    mac.version = "tech" // 按照逻辑 否决操作
    println(mac.version)
    mac.version = "ascs.tech"
    println(mac.version)
    mac.owner = "afterloe"
//    mac.owner = null // 直接报错
    println(mac.owner)

    val account = Account(mutableMapOf("name" to "afterloe", "password" to "123456"))
    println(account.name)
    println(account.password)
}