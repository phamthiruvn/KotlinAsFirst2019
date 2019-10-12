import kotlin.math.pow

fun main() {
    fun russian(n : Int) : String {
        fun count(n : Int) : Int {
            var n1 = n
            var m = 0
            while (n1 != 0) {
                n1 /= 10
                m += 1
            }
            return m
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

        fun sourse(n : Int) : String {

            return when (n) {
                in 1..9 -> numbers1[n]
                in 10..19 -> numbers1p5[n % 10]
                in 20..99 -> numbers2[n / 10 - 2]
                in 100..999 -> numbers3[n / 100 - 1]

                else -> ""
            }
        }

        fun three(n : Int) : String {
            var a : Int
            var n1 = n
            var k = 1
            var result = ""
            while (k <= count(n)) {
                if (n1 % 100 in 10..19) {
                    k = 2
                    a = (n1 % (10.0.pow(k.toDouble()))).toInt()
                    n1 -= a
                    k += 1
                    if (a == 0) continue
                    result = sourse(a) + " " + result
                } else {
                    a = (n1 % (10.0.pow(k.toDouble()))).toInt()
                    n1 -= a
                    k += 1
                    if (a == 0) continue
                    result = sourse(a) + " " + result
                }
            }
            return result.trim()
        }

        fun threenext(n : Int) : String {

            val alone : String
            val n3 = n / 1000
            if (n3 == 0) return ""
            return when {
                n3 % 10 == 1 && (n3 % 100 != 11) -> {
                    alone = ((three(n3) + " тысяча").trim())
                    "$alone "
                }
                n3 % 10 in 2..4 && (n3 % 100 !in 12..14) -> {
                    alone = (three(n3) + " тысячи").trim()
                    "$alone "
                }
                n3 % 10 in 5..9 || n3 % 100 in 11..14 || n3 % 10 == 0 -> {
                    alone = (three(n3) + " тысяч").trim()
                    "$alone "
                }
                else -> ""
            }
        }

        return (threenext(n) + three(n)).trimEnd()
    }
    println((russian(332413)))

}