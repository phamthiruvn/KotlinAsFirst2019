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

    val e = File("input/markdown_simple.md").readLines().toMutableList().map { if (it == "") "</p><p>" else it }
        .joinToString("")
    println(e)
    var commands = "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]"
    var duo = mutableMapOf<Int , Int>()
    for (i in commands.indices) {
        if (commands[i] == '[') duo[i] = 1
        if (commands[i] == ']') duo[i] = -1
    }
    val keys = duo.keys.toList()
    val vals = duo.values.toList()
    for (x in keys.indices) {
        if (vals[x] == 1) {
            for (y in x until keys.size) if (vals.take(y + 1).drop(x).sum() == 0 && vals[y] == -1) {
                duo[keys[x]] = keys[y]
                duo[keys[y]] = keys[x]
                break
            }
        }
    }
    println(vals.take(1).sum())
    println(duo)
    println("IWnaqK?</b>]i</s>o-sQqP<i>CKia%E@t,]Gm<b>w<s></s>E<s>}zBqusyH4c3'U</s><s>)</s>XS[ES]9M</b>_rn-xi</i>?YZ7:<b>=FCU/</b>UlI)E`ESWWvxeib-^7=E\\\\A#flbfA<i>yJ+</i>jB'BcWhAVA,h;<i><s>f+'<b>/</b>pN(,sgeFy</s></i>%d<b>P<s>9[<i>5</i>JD</s>q:<s>=N<i>X,e/2</i>rxq#Z<i>4</i>X@</s><i>G</i>j<s>OQ]62<i>e</i></s>m@v^a</b>P</p><p></p><p>f$=)&.ZZi47R<i>12DHps4F?G94Si8ye4kOYXa}_D4:)O6XA&<s>ab{;JD8|fo&QhFyG'vy|mI|r&h!T0ZIQ!tTAYYGq7-N#<b>Ns'R?v\\\\W</b>H6`dNXc<b>_w{Le</b>}</s>5o<b>f,C5r</b>9ja\\\"Ez!r%qt|j8)<b><s>csK</s>MI(iQ1w#e\\\\9N-=wI=BTY</b>#{</i>6q_HkrY{SrDH4{%,ebtne/Rq.14D24K\\\\WF.LO9,#qa\\\"V<b></b>{uB<i>J.r3<b>O</b>vak<s>aT1<b>C?</b>qs>d)fxm</i>\\\"<i>DK<b>2kov\\\\wSDvQm<s>P</s>:_\\\"+<s>$.!z0jWf</s><s>0vv</s><s>Tm</s".replace("<p></p>",""))

}