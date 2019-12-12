import lesson4.task1.convert
import java.io.File
import kotlin.math.pow
import java.util.ArrayList
import javax.swing.text.html.HTML.Attribute.N


fun main() {
    val commands = "[+++++++++++++++++++++]+]+[[++++++++++[++++++++]++++]++]-]++[+-++-++-<[+-<"
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
    println(duo)
}



