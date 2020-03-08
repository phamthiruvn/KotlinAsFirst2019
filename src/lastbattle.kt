import junit.framework.Assert.assertEquals
import org.junit.Test
import org.omg.CORBA.INTERNAL
import java.lang.Integer.max

fun main() {
    val xy = mutableListOf<Int>(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9)
    val s = "0+ -3.5i"
    println(
        Regex("""[+-]*\d+\.*\d*""").findAll(
            when {
                !s.contains('i') -> "$s+0i"
                s.contains(Regex("""[^\d]i""")) -> s.replace(Regex("""i""") , "1i")
                s.matches(Regex("""[+-]*\d+\.*\d*i""")) -> "0+$s"
                else -> s
            }
        ).toList().map { it.value.toDouble() }
    )
    println("-3.324234i".matches(Regex("""[+-]*\d+\.*\d*i""")))
    val i: Int = -1
    println(42.toString().indexOfFirst { it == '.' })
    println(42.toString().length - 1 - max(42.toString().indexOf('.'), 0))
}
