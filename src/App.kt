fun main() {
    //уровень 6: работа со стандартным потоком
    val list = readLine()?.split(" ")?.toList() ?: return
    //уровень 1: вывод списка слов
    println("вывод списка")
    list.forEach(::println)

    //уровень 2: сортировка списка
    val sortList: List<String> = list.sorted()
    println("сортируем")
    sortList.forEach(::println)

    //уровень 3: отбрасываем все повторяющиеся элементы
    val uniqueValue = sortList.toSet()
    println("выводим уникальные значения")
    uniqueValue.forEach(::println)

    //уровень 4: работа с Map, подсчет кол-ва повторяющихся элементов
    val countUnique = sortList.groupingBy { it }.eachCount().toSortedMap()

    //уровень 5: сортировка по кол-ву повторений
    val sortCountUnique = countUnique.toList().sortedByDescending { (_, value) -> value }.toMap()
    println("кол-во уникальных значений")
    for (entry in sortCountUnique) {
        print(entry.key)
        print(" ")
        println(entry.value)
    }
}