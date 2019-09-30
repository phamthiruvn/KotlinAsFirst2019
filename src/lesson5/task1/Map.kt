@file:Suppress("UNUSED_PARAMETER" , "ConvertCallChainIntoSequence")

package lesson5.task1

/**
 * Пример
 *
 * Для заданного списка покупок `shoppingList` посчитать его общую стоимость
 * на основе цен из `costs`. В случае неизвестной цены считать, что товар
 * игнорируется.
 */
fun shoppingListCost(
    shoppingList : List<String> ,
    costs : Map<String , Double>
) : Double {
    var totalCost = 0.0

    for (item in shoppingList) {
        val itemCost = costs[item]
        if (itemCost != null) {
            totalCost += itemCost
        }
    }

    return totalCost
}

/**
 * Пример
 *
 * Для набора "имя"-"номер телефона" `phoneBook` оставить только такие пары,
 * для которых телефон начинается с заданного кода страны `countryCode`
 */
fun filterByCountryCode(
    phoneBook : MutableMap<String , String> ,
    countryCode : String
) {
    val namesToRemove = mutableListOf<String>()

    for ((name , phone) in phoneBook) {
        if (!phone.startsWith(countryCode)) {
            namesToRemove.add(name)
        }
    }

    for (name in namesToRemove) {
        phoneBook.remove(name)
    }
}

/**
 * Пример
 *
 * Для заданного текста `text` убрать заданные слова-паразиты `fillerWords`
 * и вернуть отфильтрованный текст
 */
fun removeFillerWords(
    text : List<String> ,
    vararg fillerWords : String
) : List<String> {
    val fillerWordSet = setOf(*fillerWords)

    val res = mutableListOf<String>()
    for (word in text) {
        if (word !in fillerWordSet) {
            res += word
        }
    }
    return res
}

/**
 * Пример
 *
 * Для заданного текста `text` построить множество встречающихся в нем слов
 */
fun buildWordSet(text : List<String>) : MutableSet<String> {
    val res = mutableSetOf<String>()
    for (word in text) res.add(word)
    return res
}


/**
 * Простая
 *
 * По заданному ассоциативному массиву "студент"-"оценка за экзамен" построить
 * обратный массив "оценка за экзамен"-"список студентов с этой оценкой".
 *
 * Например:
 *   buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
 *     -> mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат"))
 */
fun buildGrades(grades : Map<String , Int>) : Map<Int , List<String>> {

    var map : MutableMap<Int , List<String>> = mutableMapOf()
    val result1 : MutableList<String> = mutableListOf()
    val result2 : MutableList<String> = mutableListOf()
    val result3 : MutableList<String> = mutableListOf()
    val result4 : MutableList<String> = mutableListOf()
    val result5 : MutableList<String> = mutableListOf()

    for ((student , score) in grades) {
        when (score) {
            5 -> result5.add(student)
            4 -> result4.add(student)
            3 -> result3.add(student)
            2 -> result2.add(student)
            1 -> result1.add(student)
        }


    }
    map = mutableMapOf(
        1 to result1 ,
        2 to result2 ,
        3 to result3 ,
        4 to result4 ,
        5 to result5
    )
    return map.filterValues { it.isNotEmpty() }
}

/**
 * Простая
 *
 * Определить, входит ли ассоциативный массив a в ассоциативный массив b;
 * это выполняется, если все ключи из a содержатся в b с такими же значениями.
 *
 * Например:
 *   containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")) -> true
 *   containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")) -> false
 */
fun containsIn(a : Map<String , String> , b : Map<String , String>) : Boolean {
    for (entry in a) {
        var (x) = entry

        if ((b.containsKey(x) && b[x] == a[x]) == true) {
            return true

        }

    }

    return false
}

/**
 * Простая
 *
 * Удалить из изменяемого ассоциативного массива все записи,
 * которые встречаются в заданном ассоциативном массиве.
 * Записи считать одинаковыми, если и ключи, и значения совпадают.
 *
 * ВАЖНО: необходимо изменить переданный в качестве аргумента
 *        изменяемый ассоциативный массив
 *
 * Например:
 *   subtractOf(a = mutableMapOf("a" to "z"), mapOf("a" to "z"))
 *     -> a changes to mutableMapOf() aka becomes empty
 */
fun subtractOf(a : MutableMap<String , String> , b : Map<String , String>) {
    for ((x) in b) {
        (a.containsKey(x) && a[x] == b[x])

        b.filterKeys { (a.containsKey(x) && a[x] == b[x]) == false }
    }
}

/**
 * Простая
 *
 * Для двух списков людей найти людей, встречающихся в обоих списках.
 * В выходном списке не должно быть повторяюихся элементов,
 * т. е. whoAreInBoth(listOf("Марат", "Семён, "Марат"), listOf("Марат", "Марат")) == listOf("Марат")
 */
fun whoAreInBoth(a : List<String> , b : List<String>) : List<String> {
    val result = mutableListOf<String>()
    for (i in a) {
        if (b.contains(i)) result.add(i)
        return result
    }
    return result
}

/**
 * Средняя
 *
 * Объединить два ассоциативных массива `mapA` и `mapB` с парами
 * "имя"-"номер телефона" в итоговый ассоциативный массив, склеивая
 * значения для повторяющихся ключей через запятую.
 * В случае повторяющихся *ключей* значение из mapA должно быть
 * перед значением из mapB.
 *
 * Повторяющиеся *значения* следует добавлять только один раз.
 *
 * Например:
 *   mergePhoneBooks(
 *     mapOf("Emergency" to "112", "Police" to "02"),
 *     mapOf("Emergency" to "911", "Police" to "02")
 *   ) -> mapOf("Emergency" to "112, 911", "Police" to "02")
 */
fun mergePhoneBooks(mapA : Map<String , String> , mapB : Map<String , String>) : Map<String , String> {
    val mapA2 = mapA.toMutableMap()
    var mapB2 = mapB.toMutableMap()
    var mapB3 = mapB
    for (entry in mapA) {
        val name = entry.key
        mapB2 = mapB2.filterKeys { it == name }.toMutableMap()

        for (entry in mapB2) {
            val name = entry.key
            var phone = entry.value
            mapB3 = mapB.filterKeys { it != name }
            if (phone != mapA[name]) phone = mapA[name] + ", " + phone

            mapA2[name] = phone

        }

    }

    mapA2.putAll(mapB3)
    return mapA2
}

/**
 * Средняя
 *
 * Для заданного списка пар "акция"-"стоимость" вернуть ассоциативный массив,
 * содержащий для каждой акции ее усредненную стоимость.
 *
 * Например:
 *   averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
 *     -> mapOf("MSFT" to 150.0, "NFLX" to 40.0)
 */
fun averageStockPrice(stockPrices : List<Pair<String , Double>>) : Map<String , Double> {
    val map = stockPrices.toMap().toMutableMap()
    fun sum(list : List<Pair<String , Double>> , first : String) : Double {
        var sum = 0.0
        for (entry in list) {

            val a = entry.first
            val b = entry.second

            if (a == first) sum += b
            else continue


        }
        return sum
    }

    fun filte(list : List<Pair<String , Double>> , first : String) : Int {
        var dem = 0
        for (entry in list) {

            val a = entry.first


            if (a == first) dem += 1
            else continue
        }
        return dem
    }
    for (entry in map) {
        val a = entry.key

        map[a] = sum(stockPrices , a) / filte(stockPrices , a)
    }
    return map
}

/**
 * Средняя
 *
 * Входными данными является ассоциативный массив
 * "название товара"-"пара (тип товара, цена товара)"
 * и тип интересующего нас товара.
 * Необходимо вернуть название товара заданного типа с минимальной стоимостью
 * или null в случае, если товаров такого типа нет.
 *
 * Например:
 *   findCheapestStuff(
 *     mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
 *     "печенье"
 *   ) -> "Мария"
 */
fun findCheapestStuff(stuff : Map<String , Pair<String , Double>> , kind : String) : String? {
    val listkind : MutableList<Pair<String , Double>> = mutableListOf()
    var costmin : Double = Double.MAX_VALUE
    for (entry in stuff) {
        val name = entry.key
        val cost = entry.value
        if (cost.first == kind) {
            listkind.add(Pair(name , cost.second))
        }


    }
    for (ok in listkind) {
        val cost = ok.second
        if (cost < costmin) costmin = cost
        else continue

    }


    for (ok in listkind) {
        if (ok.second == costmin) {
            return ok.first
        } else continue

    }
    return null
}

/**
 * Средняя
 *
 * Для заданного набора символов определить, можно ли составить из него
 * указанное слово (регистр символов игнорируется)
 *
 * Например:
 *   canBuildFrom(listOf('a', 'b', 'o'), "baobab") -> true
 */
fun canBuildFrom(chars : List<Char> , word : String) : Boolean {
    fun check(i : Int) = (0..word.length).all { chars.contains(word[i]) }
    return check(0)
}
/**
 * Средняя
 *
 * Найти в заданном списке повторяющиеся элементы и вернуть
 * ассоциативный массив с информацией о числе повторений
 * для каждого повторяющегося элемента.
 * Если элемент встречается только один раз, включать его в результат
 * не следует.
 *
 * Например:
 *   extractRepeats(listOf("a", "b", "a")) -> mapOf("a" to 2)
 */
fun extractRepeats(list : List<String>) : Map<String , Int> {
    val result = mutableMapOf<String , Int>()
    fun dem(pt : Int) : Map<String , Int> {
        var n = 0
        for (i in list.indices)
            if (list[pt] == list[i]) n += 1
        val mapA = mutableMapOf<String , Int>(list[pt] to n)
        return mapA
    }
    for (i in list.indices)
        result.putAll(dem(i))
    return result.filterValues { it != 1 }
}
/**
 * Средняя
 *
 * Для заданного списка слов определить, содержит ли он анаграммы
 * (два слова являются анаграммами, если одно можно составить из второго)
 *
 * Например:
 *   hasAnagrams(listOf("тор", "свет", "рот")) -> true
 */
fun hasAnagrams(words : List<String>) : Boolean {
    fun re(word : String) : List<String> {
        val list = mutableListOf<String>()
        for (element in word)
            list.add(element.toString())
        return list.toList()
    }

    fun final(x : Int) : Boolean {
        var result : Boolean = false
        for (i in words.indices) {
            if(i==x) continue
            val a = words[x]
            val b = words[i]
            if ((a.length == b.length) && (re(b).containsAll(re(a)))) {
                result = ((a.length == b.length) && (re(b).containsAll(re(a))))
                break
            }
        }
        return result
    }
    return (words.indices).any { final(it) == true }
}

/**
 * Сложная
 *
 * Для заданного ассоциативного массива знакомых через одно рукопожатие `friends`
 * необходимо построить его максимальное расширение по рукопожатиям, то есть,
 * для каждого человека найти всех людей, с которыми он знаком через любое
 * количество рукопожатий.
 * Считать, что все имена людей являются уникальными, а также что рукопожатия
 * являются направленными, то есть, если Марат знает Свету, то это не означает,
 * что Света знает Марата.
 *
 * Например:
 *   propagateHandshakes(
 *     mapOf(
 *       "Marat" to setOf("Mikhail", "Sveta"),
 *       "Sveta" to setOf("Marat"),
 *       "Mikhail" to setOf("Sveta")
 *     )
 *   ) -> mapOf(
 *          "Marat" to setOf("Mikhail", "Sveta"),
 *          "Sveta" to setOf("Marat", "Mikhail"),
 *          "Mikhail" to setOf("Sveta", "Marat")
 *        )
 */
fun propagateHandshakes(friends : Map<String , Set<String>>) : Map<String , Set<String>> = TODO()

/**
 * Сложная
 *
 * Для заданного списка неотрицательных чисел и числа определить,
 * есть ли в списке пара чисел таких, что их сумма равна заданному числу.
 * Если да, верните их индексы в виде Pair<Int, Int>;
 * если нет, верните пару Pair(-1, -1).
 *
 * Индексы в результате должны следовать в порядке (меньший, больший).
 *
 * Постарайтесь сделать ваше решение как можно более эффективным,
 * используя то, что вы узнали в данном уроке.
 *
 * Например:
 *   findSumOfTwo(listOf(1, 2, 3), 4) -> Pair(0, 2)
 *   findSumOfTwo(listOf(1, 2, 3), 6) -> Pair(-1, -1)
 */
fun findSumOfTwo(list : List<Int> , number : Int) : Pair<Int , Int> = TODO()

/**
 * Очень сложная
 *
 * Входными данными является ассоциативный массив
 * "название сокровища"-"пара (вес сокровища, цена сокровища)"
 * и вместимость вашего рюкзака.
 * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
 * которые вы можете унести в рюкзаке.
 *
 * Перед решением этой задачи лучше прочитать статью Википедии "Динамическое программирование".
 *
 * Например:
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     850
 *   ) -> setOf("Кубок")
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     450
 *   ) -> emptySet()
 */
fun bagPacking(treasures : Map<String , Pair<Int , Int>> , capacity : Int) : Set<String> = TODO()