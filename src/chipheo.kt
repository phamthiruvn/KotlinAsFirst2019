import java.lang.Integer


fun main() {
    val jumps = "706 % - 717 - 703"
    val reg = Regex("""[^(\d\s%-)]""").find("700 717 g 707 % 754")?.value
    println(reg)
    val jmps = "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".split(" ")

    val expression = "a"
    val exp = expression.split(" ")
    require(exp[0] != "")
    var op = 1
    var result = 0
    for (i in exp.indices) {
        if (i % 2 == 0) {
            try {
                result += exp[i].toInt() * op
                require(exp[i].toList().all { it in '0'..'9' })
            } catch (e : NumberFormatException) {
                throw NumberFormatException("Only signed numbers are allowed")
            }
        } else when {
            exp[i] == "+" -> op = 1
            exp[i] == "-" -> op = -1
            else -> throw IllegalArgumentException()
        }
    }
    print(result)


}




