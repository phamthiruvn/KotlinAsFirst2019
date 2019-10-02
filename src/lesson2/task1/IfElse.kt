@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt


fun main() {
    val x1 = quadraticRootNumber(2.0, 4.0, 2.0)
    println("Result " + x1)
    val x2: String = ageDescription(112)
    println("Result " + x2)


}

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}


/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int) = when {
    age in 5..20 -> "$age лет"
    age in 105..120 -> "$age лет"
    (age < 5 || age > 20) && (age % 10) == 1 -> "$age год"
    (age < 5 || age > 20) && ((age % 10) == 2 || (age % 10) == 3 || (age % 10) == 4) -> "$age года"
    else -> "$age лет"
}


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val s: Double = (t1 * v1 + t2 * v2 + t3 * v3) / 2
    return when (s) {
        in 0.0..v1 * t1 -> s / v1
        in v1 * t1..(v2 * t2 + v1 * t1) -> t1 + (s - v1 * t1) / v2
        in (v2 * t2 + v1 * t1)..2 * s -> t1 + t2 + (s - v1 * t1 - v2 * t2) / v3
        else -> 0.0
    }
}


/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
) = when {
    (kingX == rookX1 || kingY == rookY1) && (kingX == rookX2 || kingY == rookY2) -> 3
    kingX == rookX1 || kingY == rookY1 -> 1
    kingX == rookX2 || kingY == rookY2 -> 2
    else -> 0
}


/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
) = when {
    ((kingX == rookX || kingY == rookY) && ((kingX + kingY) == (bishopX + bishopY) || (kingX - kingY) == (bishopX - bishopY))) -> 3
    (kingX == rookX || kingY == rookY) -> 1
    ((kingX + kingY) == (bishopX + bishopY) || (kingX - kingY) == (bishopX - bishopY)) -> 2
    else -> 0
}


/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val c1 = maxOf(a, b, c)
    val a1 = minOf(a, b, c)
    val b1 = a + b + c - a1 - c1
    val corner = ((a1 * a1 + b1 * b1 - c1 * c1) / (2 * a1 * b1))
    return when {
        a1 + b1 < c1 -> -1
        corner < 0 -> 2
        corner > 0 -> 0
        else -> 1
    }
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    val ad = abs(a - d)
    val bc = abs(b - c)
    val ab = abs(a - b)
    val dc = abs(d - c)
    return when {
        ((a in c..d && b !in c..d) || (b in c..d && a !in c..d)) -> minOf(ad, bc)
        ((a in c..d && b in c..d) || (c in a..b && d in a..b)) -> minOf(ab, dc)
        else -> -1
    }
}
