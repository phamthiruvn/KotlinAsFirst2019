fun main() {
    val treasure = mapOf("0" to (323 to 2) , "Слиток" to (324 to 1))
    val capacity = 384
    val names = treasure.keys.toList()
    val result = mutableListOf<String>()
    var array = mutableListOf<MutableList<Pair<
            List<String> , Int>>>()
    val bec = treasure.map { it.value.first }.toList()

    val xena = treasure.map { it.value.second }.toList()
    for (i : Int in 0..treasure.size) {
        array.add(mutableListOf())
        for (j : Int in 0..capacity)
            array[i].add(Pair(mutableListOf() , 0))
    }
    for (i in 0..treasure.size) {
        for (j in 0..capacity) {
            if (i == 0 || j == 0)
                array[i][j] = Pair(mutableListOf() , 0)
            else if (bec[i - 1] <= j) {
                array[i][j] = Pair(
                    array[i - 1][j - bec[i - 1]].first + names[i - 1] ,
                    maxOf(xena[i - 1] + array[i - 1][j - bec[i - 1]].second , array[i - 1][j].second)
                )
                if (array[i][j].second == array[i-1][j].second) array[i][j] = Pair(
                    array[i - 1][j].first ,
                    array[i - 1][j].second
                )
            } else
                array[i][j] = array[i - 1][j]

        }
    }
    println(array[treasure.size][capacity].first)
}




