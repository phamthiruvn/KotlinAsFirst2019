import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val lol = File("input/chaotic_in1.txt").readLines()
    val best = (lol.maxBy { it.length } ?: "").length
    println(lol.filter { it.toLowerCase().toSet().count() == best }.joinToString(", "))

}






