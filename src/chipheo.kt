import lesson4.task1.russian
import ru.spbstu.wheels.sorted
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
    println("" == "")

    fun findSumOfTwo(list : List<Int> , number : Int) =
        (list.mapIndexed { index, _ ->
            Pair(
                index,
                list.indexOf(number - list[index])
            )
        }.filter { it.first != it.second && it.second != -1 } + Pair(-1, -1))[0].sorted()


    println(findSumOfTwo(listOf(1 , 2 , 3) , 6))
    println(findSumOfTwo(listOf(0 , 0 , 3) , 0))
    println(findSumOfTwo(emptyList() , 1))

}




