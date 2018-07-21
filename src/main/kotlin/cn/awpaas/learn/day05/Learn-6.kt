package cn.awpaas.learn.day05
import java.io.InputStreamReader
import java.io.BufferedReader
import java.io.File
import java.nio.charset.Charset

const val CHARSET = "UTF-8"

// 读取全部文件内容
val readFile = { fileName: String ->
    val file = File(fileName)
    if (!file.exists()) throw Exception("No such this file")
//    file.readText(Charset.forName(CHARSET)) // 读取全部内容
    file.readLines(Charset.defaultCharset()) // 按行读取
}

val readDir = { dirName: String, callback: (File) -> Unit ->
    val dir = File(dirName)
    if (dir.isFile) throw Exception("this is file !!!")
    dir.walk().iterator().forEach { callback.invoke(it) } // 目录下 所有文件 全遍历
    true
}

fun String.execute(): Process = Runtime.getRuntime().exec(this)
fun Process.text(): String {
    val reader = BufferedReader(InputStreamReader(this.inputStream))
    return reader.readLines().joinToString { "\n" }
}

fun main(args: Array<String>) {
    val content = readFile("/Users/afterloe/.gitconfig")
    println(content)
    readDir("./") { file: File ->
        println("File path is ${file.absolutePath}, name is ${file.name}")
    }

    println("exec pwd ${"pwd".execute().text()}")
}

