import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {

    val substring = File("input/top20.txt").readLines().map { it.toLowerCase() }
    val result = countSubstrings("input/top20.txt", substring)
    println(result)

}






