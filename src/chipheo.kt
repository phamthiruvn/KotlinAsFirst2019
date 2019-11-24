import java.lang.Integer


fun main() {
    val jumps = "706 % - 717 - 703"
    val reg = Regex("""[^(\d\s%-)]""").find("700 717 g 707 % 754")?.value
println(reg)
    println ("220 + 224 %+ 228 %- 230 + 232 %%- 234 %".split(" "))
    println(Regex("""\d+""").findAll(jumps).toList().map { it.value }.max())
}




