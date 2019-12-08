import lesson7.task1.countSubstrings
import ru.spbstu.wheels.toMap
import java.io.File
import java.lang.Integer


fun main() {
   val dictionary =  mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
    val dic = dictionary.mapKeys { it.key.toLowerCase() }.mapValues { it.value.toLowerCase() }
    val outputStream = File("outputName").bufferedWriter()
    val list = File("input/trans_in1.txt").readText()
    for (i in list)
    {
        print(i)

    }
    outputStream.close()
    println(dic)
    println(File("outputName").readText())
}






