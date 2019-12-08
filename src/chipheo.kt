import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val lol = File("input/width_in1.txt").readLines().map { it.trim() }
    val best = (lol.maxBy { it.length } ?: "").length
    println(best)
    val outputStream = File("input/lol.txt").bufferedWriter()
    for (line in lol)
    {
        val newline = line.split(" ")
        if (newline.joinToString(" ").length == best) println( newline.joinToString(" "))
        if (newline.size == 1 ) println(newline.joinToString(""))
        else {

        }
    }
    println(" БА - БА".trim())
}






