package cn.awpaas.learn.day02

fun main(args: Array<String>) {
    /*
    list 是不可变的集合
    mutableList 是可变的list集合
     */
    val list: List<Int> = listOf() // 创建一个空的list
    println(list.size)

    // val list: List<Int> = listOf(10) // 创建一个长度为10的list
    // val list: List<Int> = listOf(1,23,4,5,5) // 创建有内容的list
    // val list= arrayListOf(0,1,2,3,4) | listOf(0,1,2,3,4)

    /*
        创建可变集合 MutableList
     */
    val list1 = mutableListOf(1,2,3)
    println(list1::class)
//    list1.addAll(2, list)
//    list.toMutableList() // 也可以用这种方式将list 转换为 mutableList

    // list中的元素删除
    val value = list1.removeAt(0);
    println("remove first element is $value") // 2,3

    var flag = list1.set(1, 200) // 2, 200
    println("input value is $flag") // 返回删除的原value -> 3

    val target = list1.single { i -> i == 200} // 返回符合条件的单一元素，如果返回多个则会报错
    println(target)

    val list2 = mutableListOf("a", "b", "c", "d")
    // 从最右边开始计算
    val value2 = list2.reduceRight{total, v -> v + total} //dcba
    println(value2)

    // 带初始值的 reduce
    flag = list1.fold(100) { total, v -> v + total}
    println("new flag is $flag")

    println("abc is big then abd? -> ${"abc" > "abd"}") // false => 字符串比较大小是按照下标字符进行的
    println("true is big then false? -> ${true > false}") // true
}