import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.IllegalArgumentException
import java.lang.Integer


fun main() {
    fun lis(dif: Int, siz: Int ): MutableList<String> {
        val result = mutableListOf<String>()
        for (i in 0 until siz) result.add(" ".repeat(dif / (siz - 1)))
        for (i in 0 until dif % (siz - 1)) result[i] += " "
        result[result.lastIndex] = ""
        return result
    }

    val lol = File("input/width_in1.txt").readLines().map { it.split(" ").filter { it != "" }.joinToString(" ").trim() }
    val best = (lol.maxBy { it.length } ?: "").length
    val outputStream = File("input/lol.txt").bufferedWriter()
    for (line in lol) {
        val newline = line.split(" ")
        if (newline.size == 1) outputStream.write(newline.joinToString(""))
        else {
            val space = lis(best - newline.joinToString("").length , newline.size)
            newline.mapIndexed { index , _ ->
                outputStream.write(newline[index] + space[index])
            }
        }
        outputStream.newLine()
    }
    outputStream.close()


}






