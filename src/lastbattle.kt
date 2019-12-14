import java.io.File

fun main() {
    fun markdownToHtmlSimple(inputName : String , outputName : String) {
        val inputStream = File(inputName).readLines()
        val outputStream = File(outputName).bufferedWriter()
        val result = mutableListOf("<html> <body> <p>")
        var b = 1
        var s = 1
        var i = 1
        var openedP = true
        var paragraph = false
        for (line in inputStream) {
            if (!openedP && line.isNotEmpty()) {
                outputStream.write("<p>")
                openedP = true
            }
            if (line.isEmpty()) {
                if (paragraph) {
                    outputStream.write("</p>\n")
                    openedP = false
                    paragraph = false
                }
            } else {
                paragraph = true
                var a = 0
                while (a < line.length) {
                    when (a) {
                        line.indexOf("**" , a) -> {
                            if (b == 1) result.add("<b>") else result.add("</b>")
                            b = -b
                            a++
                        }
                        line.indexOf("~~" , a) -> {
                            if (s == 1) result.add("<s>") else result.add("</s>")
                            s = -s
                            a++
                        }
                        line.indexOf("*" , a) -> {
                            if (i == 1) result.add("<i>") else result.add("</i>")
                            i = -i
                        }
                        else -> result.add(line[a].toString())

                    }
                    a++
                }
            }
        }

    }
    val e = File("input/markdown_simple.md").readLines().toMutableList().map{ if (it == "") "</p><p>" else it }.joinToString("")
println(e)

}