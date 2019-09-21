import java.lang.Math.pow
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sqrt




fun main() {

    fun m(n: Int): List<Int> {
        var list: MutableList<Int> = mutableListOf()
        var x = 2
        var n1 = n
        fun many(x: Int, e: Int): List<Int> {
            var list: MutableList<Int> = mutableListOf(e)
            var x1 = x
            while (x1 != e) {


                x1 /= e
                list.add(e)
            }
            return list
        }
        for (a in 2..n) {
            if ((2..a / 2).all { a % it != 0 } && n % a == 0) {
                n1 /= a
                list.add(a)
                if (n1 % a == 0) {
                    list + many(n1, a)


                } else continue

            } else continue
        }



return list
    }
    print (m(16))
}
