import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val jumps = "706 % - 717 - 703"
    val reg = Regex("""[^(\d\s%-)]""").find("700 717 g 707 % 754")?.value
    val jmps = "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".split(" ")
    var x : String = ""
    for (line in File("input/substrings_in1.txt").readLines()) x += line


    var mapp = mutableMapOf<String , MutableList<String>>()
    val a = mapOf("Emergency" to "112" , "Fire department" to "01")
    val b = mapOf("Emergency" to "911" , "Police" to "02")
    println((a.toList() + b.toList()).groupBy({ it.first } , { it.second }))
    val lol = mapOf("Марат" to 3 , "Семён" to 5 , "Михаил" to 5)
    println(lol.toList().groupBy({ it.second } , { it.first }))

}




