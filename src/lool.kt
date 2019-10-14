import kotlin.math.nextTowards
import kotlin.math.nextUp
import kotlin.math.pow

fun main() {
    fun russian(n : Int) : String {
        var result = mutableListOf<String>(".", ".", ".", ".", ".", ".")
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
        var a: Int
        var n2 = n
        var k = 1.0
        while (k <= dem) {
            a = (n2 % (10.0.pow(k))).toInt()
            n2 -= a
            k++
            when {

                a in 1..9 -> result[0] = numbers1[a % 10]
                a in 10..19 -> result[0] = numbers1p5[n % 10]
                a in 20..99 -> result[1] = numbers2[a / 10 - 2]
                a in 100..999 -> result[2] = numbers3[a / 100 - 1]
                a / 1000 == 1 -> result[3] = "одна тысяча"
                a / 1000 == 2 -> result[3] = "две тысячи"
                a / 1000 in 3..4 -> result[3] = numbers1[(a / 1000) % 10] + " тысячи"
                a / 1000 in 5..9 -> result[3] = numbers1[(a / 1000) % 10] + " тысяч"
                a / 10000 == 1 -> result[3] = numbers1p5[(n / 1000) % 10] + " тысяч"
                a / 1000 in 20..99 -> {
                    result[4] = numbers2[a / 10000 - 2]
                }
                a / 1000 in 100..999 -> {
                    result[5] = numbers3[a / 100000 - 1]
                }
                (n / 1000) % 10 == 0 -> result[3] = "тысяч"
                else -> result.add("")

            }
        }
        return ((result.filter { it != "." }).reversed().joinToString(separator = " ")).trimStart()

    }
println(russian(200002))

}
