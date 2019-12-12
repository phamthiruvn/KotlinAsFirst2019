import lesson4.task1.convert
import java.io.File
import kotlin.math.pow
import java.util.ArrayList
import javax.swing.text.html.HTML.Attribute.N


fun main() {
    val e = File("input/jjjj.md").readLines().toList().joinToString(" ") { if (it == " ") "</p><p>" else it }
    val outputStream = File("input/lol.TXT").bufferedWriter()
    var a = 0
    var b = 1
    var s = 1
    var i = 1
    val result = mutableListOf("<html> <body> <p>")
    while (a < e.length) {
        when (a) {
            e.indexOf("\\n\\n" , a) -> {
                result.add("</p><p>")
                println("loz")
                a += 2
            }
            e.indexOf("**" , a) -> {
                if (b == 1) result.add("<b>") else result.add("</b>")
                b = -b
                a++
            }
            e.indexOf("~~" , a) -> {
                if (s == 1) result.add("<s>") else result.add("</s>")
                s = -s
                a++
            }
            e.indexOf("*" , a) -> {
                if (i == 1) result.add("<i>") else result.add("</i>")
                i = -i
            }

            else -> result.add(e[a].toString())

        }
        a++
    }
    result.add("</p></body></html>")
    println(result.joinToString(""))
    outputStream.write((result.joinToString("")))
    outputStream.close()
}




