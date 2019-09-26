@file:Suppress("UNUSED_PARAMETER" , "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import java.lang.Math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y : Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root , root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a : Double , b : Double , c : Double) : List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a , b , c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list : List<Int>) : List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list : MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list : List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array : Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str : String) : Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list : List<Int>) = list.joinToString(separator = " + " , postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v : List<Double>) : Double {
    var result : Double = 0.0
    for (i in v) {
        val i2 = i * i
        result += i2
    }
    return sqrt(result)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list : List<Double>) : Double {
    var result : Double = 0.0
    if (list.size == 0) return 0.0
    else {
        for (i in list) {
            result += i
        }

    }
    return result / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list : MutableList<Double>) : MutableList<Double> {
    val sum = list.sum()
    val minus = sum / (list.size)

    for (num in 0..list.size - 1) {
        val x = list[num] - minus
        list.removeAt(num)
        list.add(num , x)
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a : List<Int> , b : List<Int>) : Int {
    var result = 0
    if (a.size == 0 && b.size == 0) return 0
    else {
        for (i in 0..(a.size - 1)) {
            result += a[i] * b[i]


        }
        return result
    }

}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p : List<Int> , x : Int) : Int {
    var result = 0
    if (p.size == 0) return 0
    else {
        for (i in 0..(p.size - 1))
            result += p[i] * pow(x.toDouble() , i.toDouble()).toInt()
    }

    return result

}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list : MutableList<Int>) : MutableList<Int> {
    for (num in 1..list.size - 1) {
        val x : Int = list[num] + list[num - 1]
        list.removeAt(num)
        list.add(num , x)
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n : Int) : List<Int> {

    fun Prime(n : Int) : List<Int> {
        val result : MutableList<Int> = mutableListOf()
        var n1 = n

        fun isPrime(n : Int) : Boolean {
            if (n < 2) return false
            if (n == 2) return true
            if (n % 2 == 0) return false
            for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
                if (n % m == 0) return false
            }
            return true
        }
        if (n == 2) result.add(2)
        if (isPrime(n) == true && n > 2) {
            result.add(n)
            return result
        } else {
            for (i in 2 until n)
                while (n1 != 1 && isPrime(i) == true && (n1 % i == 0)) {

                    result.add(i)
                    n1 /= i


                }

            return result
        }
    }
    return Prime(n)

}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n : Int) : String {

    fun Prime(n : Int) : List<Int> {
        val result : MutableList<Int> = mutableListOf()
        var n1 = n

        fun isPrime(n : Int) : Boolean {
            if (n < 2) return false
            if (n == 2) return true
            if (n % 2 == 0) return false
            for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
                if (n % m == 0) return false
            }
            return true
        }
        if (n == 2) result.add(2)
        if (isPrime(n) == true && n > 2) {
            result.add(n)
            return result
        } else {
            for (i in 2 until n)
                while (n1 != 1 && isPrime(i) == true && (n1 % i == 0)) {

                    result.add(i)
                    n1 /= i


                }

            return result
        }
    }
    return Prime(n).joinToString(separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n : Int , base : Int) : List<Int> {
    val result : MutableList<Int> = mutableListOf()
    fun m(n0 : Int , base0 : Int) : Int {
        var n1 = n0
        var k : Int = 0
        while (n1 / base0 > 0) {
            n1 /= base0

            k += 1

        }
        return k
    }

    var n1 : Int = n
    val base1 : Int = base

    for (i in m(n1 , base1) downTo 0) {
        val l = ((pow(base1.toDouble() , i.toDouble())).toInt())
        val k = n1 / l
        n1 = n1 - k * l
        result.add(k)


    }
    return result

}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n : Int , base : Int) : String {
    var result : String = ""
    val abc : List<String> = listOf(
        "a" ,
        "b" ,
        "c" ,
        "d" ,
        "e" ,
        "f" ,
        "g" ,
        "h" ,
        "i" ,
        "j" ,
        "k" ,
        "l" ,
        "m" ,
        "n" ,
        "o" ,
        "p" ,
        "q" ,
        "r" ,
        "s" ,
        "t" ,
        "u" ,
        "v" ,
        "w" ,
        "x" ,
        "y" ,
        "z"
    )

    fun m(n0 : Int , base0 : Int) : Int {
        var n1 = n0
        var k : Int = 0
        while (n1 / base0 > 0) {
            n1 /= base0

            k += 1

        }
        return k
    }

    var n1 : Int = n
    val base1 : Int = base

    for (i in m(n1 , base1) downTo 0) {
        val l = ((pow(base1.toDouble() , i.toDouble())).toInt())
        val k = n1 / l
        n1 = n1 - k * l
        if (k in 10..36) {
            val sym = abc[k - 10]
            result += sym
            continue

        }
        result += "$k"

    }
    return result
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits : List<Int> , base : Int) : Int {
    var result : Int = 0
    for (x in 0..(digits.size - 1)) {
        result += (digits[x] * pow(base.toDouble() , (digits.size - x - 1).toDouble())).toInt()
    }



    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str : String , base : Int) : Int {
    var result : Int = 0
    var a : Int
    val abc : List<Char> = listOf(
        'a' ,
        'b' ,
        'c' ,
        'd' ,
        'e' ,
        'f' ,
        'g' ,
        'h' ,
        'i' ,
        'j' ,
        'k' ,
        'l' ,
        'm' ,
        'n' ,
        'o' ,
        'p' ,
        'q' ,
        'r' ,
        's' ,
        't' ,
        'u' ,
        'v' ,
        'w' ,
        'x' ,
        'y' ,
        'z'
    )
    for (x in 0..(str.length - 1)) {

        val sp = abc.indexOf(str[x])
        if (sp == -1) {
            a = str[x].toInt() - 48
            result += (a.toDouble() * pow(base.toDouble() , (str.length - x - 1).toDouble())).toInt()
        }

        if (sp != -1) {
            a = sp + 10
            result += (a.toDouble() * pow(base.toDouble() , (str.length - x - 1).toDouble())).toInt()
        }

    }
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n : Int) : String {
    var n1 = n
    var k = 0
    var a : Int
    var result : String = ""
    while (n1 != 0) {
        a = n1 % 10
        n1 = n1 / 10
        k += 1
        fun simple(n : Int , m : Int) : String {

            var loz : List<String> = listOf()
            var result : String = ""
            when (m) {
                1 -> {
                    loz = listOf("I" , "V" , "X")
                }
                2 -> {
                    loz = listOf("X" , "L" , "C")
                }
                3 -> {
                    loz = listOf("C" , "D" , "M")
                }
                4 -> {
                    loz = listOf("M" , "MM" , "MMM")
                }

            }
            val a : String = loz[0]
            val b : String = loz[1]
            val c : String = loz[2]

            when (n) {
                1 -> result += a
                2 -> result += (a + a)
                3 -> result += (a + a + a)
                4 -> result += (a + b)
                5 -> result += (b)
                6 -> result += (b + a)
                7 -> result += (b + a + a)
                8 -> result += (b + a + a + a)
                9 -> result += (a + c)
            }
            return result
        }
        result = simple(a , k) + result

    }
    return result
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */


fun russian(n : Int) : String {
    fun dem(n : Int) : Int {
        var n1 = n
        var m : Int = 0
        while (n1 != 0) {
            n1 /= 10
            m += 1
        }
        return m
    }

    fun sourse(n : Int) : String {
        val numbers1 : List<String> =
            listOf("нуль" , "один" , "два" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять")
        val numbers1p5 : List<String> = listOf(
            "десять" ,
            "одиннадцать" ,
            "двенадцать" ,
            "тринадцать" ,
            "четырнадцать" ,
            "пятнадцать" ,
            "шестнадцать" ,
            "семнадцать" ,
            "восемнадцать" ,
            "девятнадцать"
        )
        val numbers2 : List<String> = listOf(
            "двадцать" ,
            "тридцать" ,
            "сорок" ,
            "пятьдесят" ,
            "шестьдесят" ,
            "семьдесят" ,
            "восемьдесят" ,
            "девяносто"
        )
        val numbers3 : List<String> = listOf(
            "сто" ,
            "двести" ,
            "триста" ,
            "четыреста" ,
            "пятьсот" ,
            "шестьсот" ,
            "семьсот" ,
            "восемьсот" ,
            "девятьсот"
        )
        val alone : String
        when (n) {
            in 1..9 -> {
                alone = numbers1[n]
                return alone
            }
            in 10..19 -> {
                alone = numbers1p5[n % 10]
                return alone
            }
            in 20..99 -> {
                alone = numbers2[n / 10 - 2]
                return alone
            }
            in 100..999 -> {
                alone = numbers3[n / 100 - 1]
                return alone
            }

        }

        return ""
    }

    fun three(n : Int) : String {
        var a : Int
        var n1 = n
        var k : Int = 1
        var result : String = ""
        while (k <= dem(n)) {
            if (n1 % 100 in 10..19) {
                k = 2
                a = (n1 % (pow(10.0 , k.toDouble()))).toInt()
                n1 = n1 - a
                k += 1
                if (a == 0) continue
                result = sourse(a) + " " + result


            } else {
                a = (n1 % (pow(10.0 , k.toDouble()))).toInt()
                n1 = n1 - a
                k += 1
                if (a == 0) continue
                result = sourse(a) + " " + result

            }
        }
        return result.trim()
    }

    fun threenext(n : Int) : String {
        fun sourse1p5(n : Int) : String {
            val numbers1 : List<String> =
                listOf("" , "одна" , "две" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять")
            val numbers1p5 : List<String> = listOf(
                "десять" ,
                "одиннадцать" ,
                "двенадцать" ,
                "тринадцать" ,
                "четырнадцать" ,
                "пятнадцать" ,
                "шестнадцать" ,
                "семнадцать" ,
                "восемнадцать" ,
                "девятнадцать"
            )
            val numbers2 : List<String> = listOf(
                "двадцать" ,
                "тридцать" ,
                "сорок" ,
                "пятьдесят" ,
                "шестьдесят" ,
                "семьдесят" ,
                "восемьдесят" ,
                "девяносто"
            )
            val numbers3 : List<String> = listOf(
                "сто" ,
                "двести" ,
                "триста" ,
                "четыреста" ,
                "пятьсот" ,
                "шестьсот" ,
                "семьсот" ,
                "восемьсот" ,
                "девятьсот"
            )
            val alone : String
            when (n) {
                in 1..9 -> {
                    alone = numbers1[n]
                    return alone
                }
                in 10..19 -> {
                    alone = numbers1p5[n % 10]
                    return alone
                }
                in 20..99 -> {
                    alone = numbers2[n / 10 - 2]
                    return alone
                }
                in 100..999 -> {
                    alone = numbers3[n / 100 - 1]
                    return alone
                }
            }

            return ""
        }

        fun three1p5(n : Int) : String {
            var a : Int
            var n1 = n
            var k : Int = 1
            var result : String = ""
            while (k <= dem(n)) {
                if (n1 % 100 in 10..19) {
                    k = 2
                    a = (n1 % (pow(10.0 , k.toDouble()))).toInt()
                    n1 = n1 - a
                    k += 1
                    if (a == 0) continue
                    result = sourse1p5(a) + " " + result

                } else {
                    a = (n1 % (pow(10.0 , k.toDouble()))).toInt()
                    n1 = n1 - a
                    k += 1
                    if (a == 0) continue
                    result = sourse1p5(a) + " " + result
                }
            }
            return result.trimEnd()
        }

        val alone : String

        val n3 = n / 1000
        if (n3 == 0) return ""
        if (n3 == 0) return ""
        when {
            n3 % 10 == 1 && (n3 % 100 !in 11..20) -> {
                alone = (three1p5(n3) + " тысяча").trim()
                return alone + " "
            }
            n3 % 10 in 2..4 && (n3 % 100 !in 11..20) -> {
                alone = (three1p5(n3) + " тысячи").trim()
                return alone + " "
            }
            n3 % 10 in 5..9 && (n3 % 100 !in 11..20) -> {
                alone = (three1p5(n3) + " тысяч").trim()
                return alone + " "
            }
            n3 % 100 in 20..99 -> {
                alone = (three1p5(n3) + " тысяч").trim()
                return alone + " "
            }
            n3 % 10 == 0 -> {
                alone = (three1p5(n3) + " тысяч").trim()
                return alone + " "
            }
            n3 % 100 in 11..20 -> {
                alone = (three1p5(n3) + " тысяч").trim()
                return alone + " "
            }


        }
        return ""
    }


    return (threenext(n) + three(n)).trimEnd()
}