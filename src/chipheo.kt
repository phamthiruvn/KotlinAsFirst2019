import java.io.File

fun main() {
    val e = File("input/markdown_simple.md").readText()
    val outputStream = File("input/lol.TXT").bufferedWriter()
    var a = 0
    var b = 1
    var s = 1
    var i = 1
    val result = mutableListOf("<html> <body> <p>")
    while (a < e.length) {
        when (a) {
            e.indexOf("**", a) -> {
                if (b == 1) result.add("<b>") else result.add("</b>")
                b = -b
                a++
            }
            e.indexOf("~~", a) -> {
                if (s == 1) result.add("<s>") else result.add("</s>")
                s = -s
                a++
            }
            e.indexOf("*", a) -> {
                if (i == 1) result.add("<i>") else result.add("</i>")
                i = -i
            }
            e.indexOf("\n\n", a) -> {
                result.add("\n\n")
                a++
            }
            else -> result.add(e[a].toString())

        }
        a++
    }
    result.add("</p></body></html>")
    outputStream.write((result.joinToString("")))
    outputStream.close()
}







