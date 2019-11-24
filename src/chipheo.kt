import java.lang.Integer


fun main() {
    val jumps = "706 % - 717 - 703"
    val reg = Regex("""[^(\d\s%-)]""").find("700 717 g 707 % 754")?.value
println(reg)
    println ( Regex("""[^(\d\s-%)]""").find(jumps)?.value)
    println(Regex("""\d+""").findAll(jumps).toList().map { it.value }.max())
}




