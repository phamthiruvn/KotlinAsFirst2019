import junit.framework.Assert.assertEquals
import org.junit.Test
import org.omg.CORBA.INTERNAL

fun main() {
    val xy = mutableListOf<Int>(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9)
    val s = "23213-123i"
    println(
        Regex("""[+-]*\d*\.*\d*i*""").find(
            s + if (!s.contains('i')) "+ 0i" else "1")!!.value.replace(Regex("""i""") , "").toDouble()
    )
}
