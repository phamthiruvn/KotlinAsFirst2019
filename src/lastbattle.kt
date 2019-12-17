import lesson4.task1.convert
import java.io.File

fun main() {
    println(convert(76, 10).map { it * 12345 }.reversed())

}