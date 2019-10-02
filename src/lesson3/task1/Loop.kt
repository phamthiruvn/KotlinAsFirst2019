@file:Suppress("UNUSED_PARAMETER", "NAME_SHADOWING")

package lesson3.task1


import java.lang.Math.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var numnum = 0
    var n2 = n
    if (n2 == 0) numnum = 1
    while (n2 != 0) {
        n2 /= 10
        numnum += 1
    }
    return numnum
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a = 1
    var b = 1
    var c = 1
    if (n < 3)
        return c
    if (n > 2) {
        for (i in 3..n) {
            c = a + b
            a = b
            b = c

        }
    }
    return c
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val h = m * n
    val l = max(m, n)
    val v = min(m, n)
    for (k in 1..h) {
        if ((((l * k) % v) == 0)) {
            return (k * l)
        }
    }
    return 1
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (k: Int in 2..n) {
        if (n % k == 0) {
            return k
        }
    }
    return 1
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int) = n / minDivisor(n)

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val h = minOf(m, n)
    val i = false
    for (k: Int in 2..h) {
        if (n % k == 0 && m % k == 0) {
            return i
        }
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val m1 = ((sqrt(m.toDouble())).toInt())
    val n1 = ((sqrt(n.toDouble())).toInt())
    return if (m == m1 * m1 || n == n1 * n1) true
    else (m1 != n1)
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var xnext = x
    var count = 0
    while (xnext != 1) {
        if ((xnext % 2) == 0) {
            xnext /= 2
            count += 1
        } else {
            xnext = 3 * xnext + 1
            count += 1
        }
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var sinx = 0.0
    val x1 = x % (2 * PI)
    var phantu = 1.0
    var k = 1
    while (abs(phantu) >= eps) {
        phantu = (-1.0).pow((k - 1).toDouble()) * x1.pow((2 * k - 1).toDouble()) / factorial(2 * k - 1)
        println(phantu)
        sinx += phantu
        k += 1
    }
    return sinx
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var cosx = 0.0
    val x1 = x % (2 * PI)
    var phantu = 1.0
    var k = 0
    while (abs(phantu) >= eps) {
        phantu = (-1.0).pow((k).toDouble()) * x1.pow((2 * k).toDouble()) / factorial(2 * k)
        println(phantu)
        cosx += phantu
        k += 1
    }
    return cosx
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var any: Int
    var number1 = n
    var any10 = 0
    while (number1 > 0) {
        any = number1 % 10
        any10 = any10 * 10 + any
        number1 /= 10
    }
    return any10
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var any: Int
    var number1 = n
    var any10 = 0
    while (number1 > 0) {
        any = number1 % 10
        any10 = any10 * 10 + any
        number1 /= 10
    }
    return any10 == n
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var a = 0
    var b = 0
    var n1 = n
    while (a == b) {
        a = n % 10
        n1 /= 10
        b = n1 % 10
        if (n1 == 0) return false
    }
    return true
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    fun numberbasic(m: Int): Int {
        var k = 0
        var m1 = m
        while (m1 != 0) {
            k += 1
            m1 /= 10
        }
        return k
    }

    var h = 0
    var k = 0
    while (h < n) {
        k += 1
        h += numberbasic(k * k)
    }
    var result = k * k
    var number = k * k
    var m = h - n
    while (m != -1) {
        result = number % 10
        number /= 10
        m -= 1
    }
    return result
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {

    fun numberbasic(m: Int): Int {
        var k = 0
        var m1 = m
        while (m1 != 0) {
            k += 1
            m1 /= 10
        }
        return k
    }

    var h = 0
    var k = 0
    while (h < n) {
        k += 1
        h += numberbasic(fib(k))
    }
    var result = fib(k)
    var number = fib(k)
    var m = h - n
    while (m != -1) {
        result = number % 10
        number /= 10
        m -= 1
    }
    return result
}

