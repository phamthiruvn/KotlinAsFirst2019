import lesson4.task1.convert
import java.io.File

fun main() {
    val max = "${12345 * 76}".length + 1
    val list = convert(76, 10).map { it * 12345 }.reversed().map { "$it" }


}