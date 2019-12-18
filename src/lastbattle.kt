import lesson3.task1.numberbasic
import lesson4.task1.convert
import lesson8.task2.knightTrajectory
import lesson8.task2.square
import java.io.File
import java.lang.Math.pow
import kotlin.math.min
import kotlin.math.pow

fun main() {
    fun minus(x : String , y : String , pre : Int) : String {
        val equal = "-".repeat(maxOf(x.length , y.length))
        return " ".repeat(pre) + "$x\n" + " ".repeat(pre + x.length - y.length) + "$y\n" +
                " ".repeat(
                    min(
                        pre + x.length - y.length ,
                        pre
                    )
                ) + equal
    }

    fun printDivisionProcess(lhv : Int , rhv : Int , outputName : String) {
        val listlhv = convert(lhv , 10)
        val listMinus = convert((lhv / rhv) , 10).map { -it * rhv }
        println(" $lhv | $rhv")
        val first = if (listMinus[0] != 0) "${listMinus[0]}" else "-0"
        println(first + " ".repeat(" $lhv | $rhv".indexOf('|') - first.length + 2) + "${lhv / rhv}")
        println("-".repeat(first.length))
        val listPlus = mutableListOf<Int>()
        listPlus[0] = (lhv / 10.0.pow(("$lhv".length - first.length + 1).toDouble()) + listMinus[0]).toInt()
        for (i in 1 until listMinus.size) {
            listPlus.add(listPlus[i - 1] * 10 + listlhv[first.length - 2] + listMinus[i])
        }
        println(listPlus)
    }
    println(printDivisionProcess(19935 , 22 , ""))
}