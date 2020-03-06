@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

import java.lang.IllegalArgumentException

/**
 * Класс "расписание поездов".
 *
 * Общая сложность задания -- средняя.
 * Объект класса хранит расписание поездов для определённой станции отправления.
 * Для каждого поезда хранится конечная станция и список промежуточных.
 * Поддерживаемые методы:
 * добавить новый поезд, удалить поезд,
 * добавить / удалить промежуточную станцию существующему поезду,
 * поиск поездов по времени.
 *
 * В конструктор передаётся название станции отправления для данного расписания.
 */
class TrainTimeTable(val baseStationName: String) {
    private val trainS = mutableListOf<Train>()
    /**
     * Добавить новый поезд.
     *
     * Если поезд с таким именем уже есть, следует вернуть false и ничего не изменять в таблице
     *
     * @param train название поезда
     * @param depart время отправления с baseStationName
     * @param destination конечная станция
     * @return true, если поезд успешно добавлен, false, если такой поезд уже есть
     */
    fun addTrain(train: String, depart: Time, destination: Stop): Boolean {
        if (!trainS.map { it.name }.contains(train)) {
            trainS.add(Train(train, listOf(Stop(baseStationName, depart), destination).sortedBy { it.time }))
            return true
        }
        return false
    }

    /**
     * Удалить существующий поезд.
     *
     * Если поезда с таким именем нет, следует вернуть false и ничего не изменять в таблице
     *
     * @param train название поезда
     * @return true, если поезд успешно удалён, false, если такой поезд не существует
     */
    fun removeTrain(train: String): Boolean = trainS.removeIf{ it.name == train } != null

    /**
     * Добавить/изменить начальную, промежуточную или конечную остановку поезду.
     *
     * Если у поезда ещё нет остановки с названием stop, добавить её и вернуть true.
     * Если stop.name совпадает с baseStationName, изменить время отправления с этой станции и вернуть false.
     * Если stop совпадает с destination данного поезда, изменить время прибытия на неё и вернуть false.
     * Если stop совпадает с одной из промежуточных остановок, изменить время прибытия на неё и вернуть false.
     *
     * Функция должна сохранять инвариант: время прибытия на любую из промежуточных станций
     * должно находиться в интервале между временем отправления с baseStation и временем прибытия в destination,
     * иначе следует бросить исключение IllegalArgumentException.
     * Также, время прибытия на любую из промежуточных станций не должно совпадать с временем прибытия на другую
     * станцию или с временем отправления с baseStation, иначе бросить то же исключение.
     *
     * @param train название поезда
     * @param stop начальная, промежуточная или конечная станция
     * @return true, если поезду была добавлена новая остановка, false, если было изменено время остановки на старой
     */
    fun addStop(train: String, stop: Stop): Boolean {
        val thistrain = trainS.first{ it.name == train}
        val thistrainstop = thistrain.stops.toMutableList()
        if (stop.time in thistrainstop.map { it.time } && stop.name !in thistrainstop.map { it.name }) throw IllegalArgumentException()
        when (stop.name) {
            baseStationName -> {
                thistrainstop[0] = stop
                if (stop.time >= thistrainstop[1].time) throw IllegalArgumentException()
                trainS.remove(thistrain)
                trainS.add(Train(thistrain.name, thistrainstop.sortedBy { it.time }))
                return false
            }
            thistrainstop.last().name -> {
                thistrainstop[thistrainstop.lastIndex] = stop
                if (stop.time <= thistrainstop[thistrainstop.lastIndex - 1].time) throw IllegalArgumentException()
                trainS.remove(thistrain)
                trainS.add(Train(thistrain.name, thistrainstop.sortedBy { it.time }))
                return false
            }
            in thistrainstop.map { it.name } -> {
                if(stop.time !in thistrainstop.first().time..thistrainstop.last().time) throw IllegalArgumentException()
                thistrainstop.removeIf { it.name == stop.name }
                thistrainstop.add(stop)
                trainS.remove(thistrain)
                trainS.add(Train(thistrain.name, thistrainstop.sortedBy { it.time }))
                return false
            }
            else -> {

                if(stop.time !in thistrainstop.first().time..thistrainstop.last().time) throw IllegalArgumentException()
                thistrainstop.add(stop)
                trainS.remove(thistrain)
                trainS.add(Train(thistrain.name, thistrainstop.sortedBy { it.time }))
                return true
            }
        }
    }

    /**
     * Удалить одну из промежуточных остановок.
     *
     * Если stopName совпадает с именем одной из промежуточных остановок, удалить её и вернуть true.
     * Если у поезда нет такой остановки, или stopName совпадает с начальной или конечной остановкой, вернуть false.
     *
     * @param train название поезда
     * @param stopName название промежуточной остановки
     * @return true, если удаление успешно
     */
    fun removeStop(train: String, stopName: String): Boolean {
        val thistrain = trainS.first{ it.name == train}
        val thistrainstop = thistrain.stops.toMutableList()
        val i = thistrainstop.map { it.name }.indexOf(stopName)
        if (i != -1 && i != 0 && i != thistrainstop.lastIndex){
            thistrainstop.removeIf { it.name == stopName }
            trainS.remove(thistrain)
            trainS.add(Train(thistrain.name, thistrainstop.sortedBy { it.time }))
            return true
        }
        return false
    }

    /**
     * Вернуть список всех поездов, упорядоченный по времени отправления с baseStationName
     */
    fun trains(): List<Train> = trainS.sortedBy { it.stops.first { it.name == baseStationName }.time }

    /**
     * Вернуть список всех поездов, отправляющихся не ранее currentTime
     * и имеющих остановку (начальную, промежуточную или конечную) на станции destinationName.
     * Список должен быть упорядочен по времени прибытия на станцию destinationName
     */
    fun trains(currentTime: Time, destinationName: String): List<Train> {
        val result = mutableListOf<Train>()
        for (i in trainS){
            val stopss = i.stops
            if (stopss.map { it.name }.contains(destinationName) && stopss.first { it.name == baseStationName }.time >= currentTime ) result.add(i)
        }
        return result.sortedBy { it.stops.first { it.name == destinationName }.time }
    }

    /**
     * Сравнение на равенство.
     * Расписания считаются одинаковыми, если содержат одинаковый набор поездов,
     * и поезда с тем же именем останавливаются на одинаковых станциях в одинаковое время.
     */
    override fun equals(other: Any?): Boolean = other is TrainTimeTable && other.trains() == trains()

    override fun hashCode() =
        trainS.fold(1, { result, train -> result + train.name.hashCode() + train.stops.sumBy { it.hashCode() } })

}

/**
 * Время (часы, минуты)
 */
data class Time(val hour: Int, val minute: Int) : Comparable<Time> {
    /**
     * Сравнение времён на больше/меньше (согласно контракту compareTo)
     */
    override fun compareTo(other: Time): Int = (this.hour - other.hour) * 60 + this.minute - other.minute
}

/**
 * Остановка (название, время прибытия)
 */
data class Stop(val name: String, val time: Time)

/**
 * Поезд (имя, список остановок, упорядоченный по времени).
 * Первой идёт начальная остановка, последней конечная.
 */
data class Train(val name: String, val stops: List<Stop>) {
    constructor(name: String, vararg stops: Stop) : this(name, stops.asList())

}