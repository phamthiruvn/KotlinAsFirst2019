import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
    val file = File("input/sibilants_in1.txt").readLines()
    val changee = mapOf('Ы' to 'И' , 'Я' to 'А' , 'Ю' to 'У')
    val nocle = listOf('Ж' , 'Ч' , 'Ш' , 'Щ')
    val outputStream = File("temp.txt").bufferedWriter()
    for (line in File("input/sibilants_in1.txt").readLines()) {
        if (line.isEmpty()) {
            outputStream.newLine()
            continue
        }
        for (word in line.split("")) {
            val wordlist = word.toMutableList()
            wordlist.mapIndexed { index , _ ->
                if (wordlist[index].toUpperCase() in nocle && wordlist[index + 1].toUpperCase() in changee.keys)
                { wordlist[index + 1] = changee[wordlist[index + 1].toUpperCase()]!! }

            }
            outputStream.write(word)
        }
        outputStream.newLine()
    }
    outputStream.close()
    println(File("temp.txt").readText())
}






