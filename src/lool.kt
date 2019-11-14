import lesson4.task1.convert
import kotlin.math.pow
import java.util.ArrayList


fun main() {
    fun timeStrToSeconds(str : String) : Int {
        val parts = str.split(":")
        var result = 0
        try {
            for (part in parts) {
                val number = part.toInt()
                result = result * 60 + number
            }
            return result
        } catch (e : NumberFormatException) {
            return -1
        }
    }

    fun flattenPhoneNumber(phone : String) : String {
        var result = ""
        val phonee = phone.split(" " , "-").filter { it != "" }
        try {
            for (part in phonee) {
                part.toInt()
                result += part
            }
        } catch (e : NumberFormatException) {
            return ""
        }
        return result
    }

    val loz =
        "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".split("; ").map { it.split(" ") }.maxBy { it[1].toDouble() }?.get(0)


    println(loz)
}




