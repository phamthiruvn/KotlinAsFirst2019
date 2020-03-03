@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import lesson1.task1.sqr

/**
 * Класс "комплексое число".
 *
 * Общая сложность задания -- лёгкая.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double): this(x, 0.0)

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String): this(
        Regex("""[+-]*\d+\.*\d*i*""").findAll(s).toList().map{it.value}.map {if (it.contains('i')) 0.0 else it.toDouble()}.getOrElse(0) { 0.0 },
        Regex("""[+-]*\d+\.*\d*i""").find(s + if (!s.contains('i')) "+ 0i" else "+ 1i" , 0)!!.value.replace(Regex("""i"""), "").toDouble()
    )

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-im, -re)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = plus(-other)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex = Complex(re * other.re - im * other.im, im * other.re + re * other.im)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val x = Complex(re, im) * Complex(other.re, -other.im)
        val y = sqr(other.re) + sqr(other.im)
        return Complex(x.re / y, x.im /y)
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other is Complex -> im == other.im && re == other.re
        else -> false
    }

    /**
     * Получение хеш-кода
     */
    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + im.hashCode()
        result = prime * result + re.hashCode()
        return result
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = "$re" + if (im > 0.0) "+" else "" + "$im" + "i"
}