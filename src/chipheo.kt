import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val file = File("input/sibilants_in1.txt").readLines()
    val changee = mapOf("И" to "Ы" , "А" to "Я" , "У" to "Ю")
    val nocle = listOf("Ж" , "Ч" , "Ш" , "Щ")
    val outputStream = File("temp.txt").bufferedWriter()
    for (line in File("input/sibilants_in1.txt").readLines()) {
        if (line.isEmpty()) {
            outputStream.newLine()
            continue
        }
        for (word in line.split("")) {
            word.toList().mapIndexed { index, c ->   }
            outputStream.write(word)
        }
        outputStream.newLine()
    }
    outputStream.close()
    println(File("temp.txt").readText())
}






