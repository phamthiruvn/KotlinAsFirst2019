import lesson4.task1.russian
import java.lang.Math.pow


fun main() {


    val lol = mapOf(
        "1" to setOf("2") ,
        "2" to setOf("3" , "4") ,
        "3" to setOf("1")

    )
    val alls = (lol.values.fold(
        listOf<String>() ,
        { sum , next -> sum + next }).map { Pair(it , setOf<String>()) }.toMap() + lol)

    val allss = alls.mapValues { it.value + it.key }
    println(allss)
    println(""=="")
}




