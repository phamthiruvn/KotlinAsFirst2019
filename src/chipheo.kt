import lesson1.task1.accountInThreeYears
import lesson6.task1.computeDeviceCells
import java.io.File

fun main() {
    fun computeDeviceCells(cells : Int , commands : String , limit : Int) : List<Int> {
        val checkcmd = commands.toList().map {
            when (it) {
                '[' -> 1
                ']' -> -1
                else -> 0
            }
        }
        val duo = mutableMapOf<Int , Int>()
        for (x in checkcmd.indices) {
            if (checkcmd[x] == 1) {
                for (y in x until checkcmd.size) if (checkcmd.take(y + 1).drop(x).sum() == 0 && checkcmd[y] == -1) {
                    duo[x] = y
                    duo[y] = x
                    break
                }
            }
        }
        val set = setOf('+' , '-' , '>' , '<' , '[' , ']' , ' ')
        require(commands.toSet() + set == set)
        val result = mutableListOf<Int>()
        var cmd = 0
        var numcmd = 0
        var sensor = cells / 2
        for (i in 0 until cells) result.add(0)
        while (cmd < commands.length) {
            when (commands[cmd]) {
                '+' -> result[sensor]++
                '-' -> result[sensor]--
                '>' -> sensor++
                '<' -> sensor--
                '[' -> if (result[sensor] == 0) cmd = duo[cmd] ?: cmd
                ']' -> if (result[sensor] != 0) cmd = duo[cmd] ?: cmd
            }
            cmd++
            numcmd++
        }
        return result.toList()
    }
    println(computeDeviceCells(11 , "<<<<< + >>>>>>>>>> --[<-] >+" , 10000))
    println(computeDeviceCells(11 , "<<<<< + >>>>>>>>>> --[<-] >+[>+]" , 10000))
    println(computeDeviceCells(11 , "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++" , 10000))
    println(computeDeviceCells(11 , "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]" , 10000))
}







