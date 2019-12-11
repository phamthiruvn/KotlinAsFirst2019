import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.IllegalArgumentException
import java.lang.Integer


fun main() {
    val lol = File("input/markdown_simple.md").readText()
    val outputStream = File("input/lol.TXT").bufferedWriter()
    var a = 0
    var b = 1
    var s = 1
    var i = 1
    outputStream.write("<html> <body> <p>")
    while (a < lol.length - 1) {
        when {
            a < lol.length - 3 && lol[a + 2] == '\n' && lol[a] == '\n'
            -> {
                outputStream.write("</p><p>")
                a += 3
            }
            a == lol.indexOf("**" , a) -> {
                if (b == 1) outputStream.write("<b>") else outputStream.write("</b>")
                b = -b
                a += 2
            }

            a == lol.indexOf("~~" , a) -> {
                if (s == 1) outputStream.write("<s>") else outputStream.write("</s>")
                s = -s
                a += 2
            }
            a == lol.indexOf("*" , a) -> {
                if (i == 1) outputStream.write("<i>") else outputStream.write("</i>")
                i = -i
            }
            lol[a].toInt() != 13 -> {
                outputStream.write(lol[a].toString())
            }

        }
        a++
    }
    outputStream.write("</p><body><html>")
    outputStream.close()
    println(File("input/lol.TXT").readText())

}






