@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

import com.sun.org.apache.xpath.internal.compiler.FunctionTable
import java.lang.IllegalStateException
import kotlin.math.abs

/**
 * Класс "табличная функция".
 *
 * Общая сложность задания -- средняя.
 * Объект класса хранит таблицу значений функции (y) от одного аргумента (x).
 * В таблицу можно добавлять и удалять пары (x, y),
 * найти в ней ближайшую пару (x, y) по заданному x,
 * найти (интерполяцией или экстраполяцией) значение y по заданному x.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class TableFunction {

    private var xy = mutableMapOf<Double, Double>()

    /**
     * Количество пар в таблице
     */
    val size: Int get() = xy.size

    /**
     * Добавить новую пару.
     * Вернуть true, если пары с заданным x ещё нет,
     * или false, если она уже есть (в этом случае перезаписать значение y)
     */
    fun add(x: Double, y: Double): Boolean = xy.put(x, y) == null

    /**
     * Удалить пару с заданным значением x.
     * Вернуть true, если пара была удалена.
     */
    fun remove(x: Double): Boolean = xy.remove(x) != null

    /**
     * Вернуть коллекцию из всех пар в таблице
     */
    fun getPairs(): Collection<Pair<Double, Double>> = xy.toList()

    /**
     * Вернуть пару, ближайшую к заданному x.
     * Если существует две ближайшие пары, вернуть пару с меньшим значением x.
     * Если таблица пуста, бросить IllegalStateException.
     */
    fun findPair(x: Double): Pair<Double, Double>? {
        if (xy.isEmpty()) throw IllegalStateException()
        val new = xy.toList().sortedBy { abs(it.first - x) }
        return new.first()
    }

    /**
     * Вернуть значение y по заданному x.
     * Если в таблице есть пара с заданным x, взять значение y из неё.
     * Если в таблице есть всего одна пара, взять значение y из неё.
     * Если таблица пуста, бросить IllegalStateException.
     * Если существуют две пары, такие, что x1 < x < x2, использовать интерполяцию.
     * Если их нет, но существуют две пары, такие, что x1 < x2 < x или x > x2 > x1, использовать экстраполяцию.
     */
    fun getValue(x: Double): Double {
        if (xy.isEmpty()) throw IllegalStateException()
        if (xy.size == 1) return xy.toList()[0].second
        val new = xy.toList().sortedBy { it.first }
        val meu = xy.toList().sortedByDescending { it.first }
        val xs = xy.keys
        return when {
            x < xs.min()!! -> new[0].second + (x - new[0].first) / (new[1].first - new[0].first) * (new[1].second - new[0].second)
            x > xs.max()!! -> meu[0].second + (x - meu[0].first) / (meu[0].first - meu[1].first) * (meu[0].second - meu[1].second)
            else -> {
                val newnew = xy.toList().sortedBy { abs(it.first - x) }
                val x1 = newnew[0]
                val x2 = newnew[1]
                (x2.second * (x - x1.first) + x1.second * (x2.first - x)) / (x2.first - x1.first) }
        }
    }

    /**
     * Таблицы равны, если в них одинаковое количество пар,
     * и любая пара из второй таблицы входит также и в первую
     */
    override fun equals(other: Any?): Boolean = other is TableFunction && other.xy == this.xy

    override fun hashCode(): Int =
        xy.toList().fold(1, { result, (x, y) -> result + x.hashCode() + y.hashCode() })
}