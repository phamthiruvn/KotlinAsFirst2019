import kotlin.math.nextTowards
import kotlin.math.nextUp
import kotlin.math.pow

fun main() {
    fun russian(n : Int) : String {
        var result = mutableListOf<String>()
        var n1 = n
        var dem = 0
        if (n == 0) dem = 1
        while (n1 != 0) {
            n1 /= 10
            dem++
        }
        val numbers1 =
            listOf("нуль" , "один" , "два" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять")
        val numbers1p5 = listOf(
            "десять" ,
            "одиннадцать" ,
            "двенадцать" ,
            "тринадцать" ,
            "четырнадцать" ,
            "пятнадцать" ,
            "шестнадцать" ,
            "семнадцать" ,
            "восемнадцать" ,
            "девятнадцать"
        )
        val numbers2 = listOf(
            "двадцать" ,
            "тридцать" ,
            "сорок" ,
            "пятьдесят" ,
            "шестьдесят" ,
            "семьдесят" ,
            "восемьдесят" ,
            "девяносто"
        )
        val numbers3 = listOf(
            "сто" ,
            "двести" ,
            "триста" ,
            "четыреста" ,
            "пятьсот" ,
            "шестьсот" ,
            "семьсот" ,
            "восемьсот" ,
            "девятьсот"
        )
        var a : Int
        var n2 = n
        var k = 1.0
        while (k <= dem) {
            a = (n2 % (10.0.pow(k))).toInt()
            n2 -= a
            println(a)
            k++
            when {
                a == 0 -> result.add(".")
                a in 1..9 -> result.add(numbers1[a % 10])
                a in 10..19 -> {
                    result[0] = "."
                    result.add(numbers1p5[a % 10])
                }
                a in 20..99 -> result.add(numbers2[a / 10 - 2])
                a in 100..999 -> result.add(numbers3[a / 100 - 1])
                a / 1000 == 1 -> result.add("одна тысяча")
                a / 1000 == 2 -> result.add("две тысячи")
                a / 1000 in 3..9 -> result.add(numbers1[(a / 1000) % 10] + " тысяч")
                a / 10000 == 1 -> {
                    result[3] = "."
                    result.add(numbers1p5[(n / 1000) % 100] + " тысяч")
                }
                a / 1000 in 20..99 -> result.add(numbers2[a / 10000 - 2])
                a / 1000 in 100..999 -> result.add(numbers3[a / 100000 - 1])
                else -> result.add("")

            }
        }
        println(result)
        return result.filter { it != "." }.reversed().joinToString(separator = " ")

    }

    fun polynom(p : List<Int> , x : Int) = p

    fun times(a : List<Int> , b : List<Int>) = (a.map { it * b[a.indexOf(it)] }).sum()

    fun accumulate(list : MutableList<Int>) : List<Int> {
        val newlist = list.map { list.subList(0 , list.indexOf(it) + 1).sum() }
        for (num in 0 until list.size) {
            list[num] = newlist[num]
        }
        return list
    }
    println(polynom(listOf(-1000 , -100) , -20))
}
