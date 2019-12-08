import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val lol = File("input/lol.txt").readLines()
    val best = (lol.maxBy { it.length } ?: "").length
    println(best)
    val outputStream = File("outputName").bufferedWriter()
    for (line in lol) {

    }
    outputStream.close()
    println(File("outputName").readText())
}






