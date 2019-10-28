import java.lang.Math.pow


fun main() {

    fun decimalFromString(str : String , base : Int) : Int {
        var result : Int = 0
        var a : Int
        val abc : List<Char> = listOf(
            'a' ,
            'b' ,
            'c' ,
            'd' ,
            'e' ,
            'f' ,
            'g' ,
            'h' ,
            'i' ,
            'j' ,
            'k' ,
            'l' ,
            'm' ,
            'n' ,
            'o' ,
            'p' ,
            'q' ,
            'r' ,
            's' ,
            't' ,
            'u' ,
            'v' ,
            'w' ,
            'x' ,
            'y' ,
            'z'
        )
        for (x in 0..(str.length - 1)) {

            val sp = abc.indexOf(str[x])
            if (sp == -1) {
                a = str[x].toInt() - 48
                result += (a.toDouble() * pow(base.toDouble() , (str.length - x - 1).toDouble())).toInt()
            }

            if (sp != -1) {
                a = sp + 10
                result += (a.toDouble() * pow(base.toDouble() , (str.length - x - 1).toDouble())).toInt()
            }

        }
        return result
    }

    fun convertToString(n : Int , base : Int) : String {
        var result : String = ""
        val abc : List<String> = listOf(
            "a" ,
            "b" ,
            "c" ,
            "d" ,
            "e" ,
            "f" ,
            "g" ,
            "h" ,
            "i" ,
            "j" ,
            "k" ,
            "l" ,
            "m" ,
            "n" ,
            "o" ,
            "p" ,
            "q" ,

            "r" ,
            "s" ,
            "t" ,
            "u" ,
            "v" ,
            "w" ,
            "x" ,
            "y" ,
            "z"
        )

        fun m(n0 : Int , base0 : Int) : Int {
            var n1 = n0
            var k : Int = 0
            while (n1 / base0 > 0) {
                n1 /= base0

                k += 1

            }
            return k
        }

        var n1 : Int = n
        val base1 : Int = base

        for (i in m(n1 , base1) downTo 0) {
            val l = ((pow(base1.toDouble() , i.toDouble())).toInt())
            val k = n1 / l
            n1 = n1 - k * l
            if (k in 10..36) {
                val sym = abc[k - 10]
                result += sym
                continue

            }
            result += "$k"

        }
        return result
    }

    val lol = mapOf(
        "Marat" to setOf("Sveta") ,
        "Sveta" to setOf("Mikhail")
    )
    val allfriends = (lol.values.fold(
        listOf<String>() ,
        { sum , next -> sum + next })).map { Pair(it , setOf<String>()) }.toMap() + lol + mapOf()

    val plusthemselves : Map<String , Set<String>> = allfriends.mapValues {
        it.value + it.key
    }

    val connect = allfriends.mapValues { it -> it.value.map { plusthemselves[it] } }.mapValues {
        it.value.fold(
            listOf<String>() ,
            { sum , next -> sum + next!! }).toSet()
    }.mapValues { it.value - it.key }

println(allfriends)
    println(plusthemselves)
    println(connect)


}
