@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1


import kotlin.math.max
import kotlin.math.pow

/**
 * Класс "полином с вещественными коэффициентами".
 *
 * Общая сложность задания -- сложная.
 * Объект класса -- полином от одной переменной (x) вида 7x^4+3x^3-6x^2+x-8.
 * Количество слагаемых неограничено.
 *
 * Полиномы можно складывать -- (x^2+3x+2) + (x^3-2x^2-x+4) = x^3-x^2+2x+6,
 * вычитать -- (x^3-2x^2-x+4) - (x^2+3x+2) = x^3-3x^2-4x+2,
 * умножать -- (x^2+3x+2) * (x^3-2x^2-x+4) = x^5+x^4-5x^3-3x^2+10x+8,
 * делить с остатком -- (x^3-2x^2-x+4) / (x^2+3x+2) = x-5, остаток 12x+16
 * вычислять значение при заданном x: при x=5 (x^2+3x+2) = 42.
 *
 * В конструктор полинома передаются его коэффициенты, начиная со старшего.
 * Нули в середине и в конце пропускаться не должны, например: x^3+2x+1 --> Polynom(1.0, 2.0, 0.0, 1.0)
 * Старшие коэффициенты, равные нулю, игнорировать, например Polynom(0.0, 0.0, 5.0, 3.0) соответствует 5x+3
 */
class Polynom(vararg coeffs: Double) {
    private val list = coeffs.toList()

    /**
     * Конструктор из строки an * x^n + an-1 * x^n-1...a1 * x + a0
     * Все коэффициенты должны быть, т.е Polynom(1.0, 0.0) == "x + 0.0"
     */
    constructor(l: List<Double>) : this(*l.toDoubleArray())

    /**
     * Геттер: вернуть значение коэффициента при x^i
     */
    fun coeff(i: Int): Double = list[list.size - i -1]

    /**
     * Расчёт значения при заданном x
     */
    fun getValue(x: Double): Double {
        var result = 0.0
        for (i in list.indices) result += list.reversed()[i] * x.pow(i)
        return result
    }

    /**
     * Степень (максимальная степень x при ненулевом слагаемом, например 2 для x^2+x+1).
     *
     * Степень полинома с нулевыми коэффициентами считать равной 0.
     * Слагаемые с нулевыми коэффициентами игнорировать, т.е.
     * степень 0x^2+0x+2 также равна 0.
     */
    fun degree(): Int {
        var result = 0
        for (i in list.indices) if (list[i] != 0.0) {
            result = list.lastIndex - i
            break
        }
        return result
    }

    /**
     * Сложение
     */
    operator fun plus(other: Polynom): Polynom {
        val degree = max(other.degree(), this.degree())
        var max = this.list
        var min = other.list
        if (degree == other.degree()) {
            min = this.list
            max = other.list
        }
        val start = max.size - min.size
        var result = max.toMutableList()
        for (i in start until max.size) {
            result[i] += min[i - start]
        }
        return Polynom(result)
    }

    /**
     * Смена знака (при всех слагаемых)
     */
    operator fun unaryMinus() = Polynom(this.list.map { -it })

    /**
     * Вычитание
     */
    operator fun minus(other: Polynom): Polynom = this.plus(other.unaryMinus())

    /**
     * Умножение
     */
    operator fun times(other: Polynom): Polynom {
        var max = this.list.reversed()
        var min = other.list.reversed()
        var result = mutableListOf<Double>()
        for (k in 0..max.lastIndex + min.lastIndex) result.add(0.0)
        for (i in max.indices){
            for (j in min.indices) {
                result[i + j] += max[i] * min[j]
            }
        }
        return Polynom(result.reversed())
    }

    /**
     * Деление
     *
     * Про операции деления и взятия остатка см. статью Википедии
     * "Деление многочленов столбиком". Основные свойства:
     *
     * Если A / B = C и A % B = D, то A = B * C + D и степень D меньше степени B
     */
    operator fun div(other: Polynom): Polynom {
        when {
            this.degree() < other.degree() -> return Polynom(0.0)
            this == other -> return Polynom(1.0)
        }
        var res = mutableListOf<Double>()
        for (k in 0 until this.degree() - other.degree() + 1) res.add(0.0)
        var newi = this
        for (i in res.indices) {
            res[i] = newi.coeff(newi.degree()) / other.coeff(other.degree())
            newi = this - Polynom(res) * other
        }
        return Polynom(res)
    }

    /**
     * Взятие остатка
     */
    operator fun rem(other: Polynom) = this - (this / other) * other

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = other is Polynom && this.hashCode() == other.hashCode()

    /**
     * Получение хеш-кода
     */
    override fun hashCode() = this.getValue(31.0).toInt()
}
