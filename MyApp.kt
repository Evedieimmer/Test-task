
data class TextList(
    val word: String,
    val count: Int
)


fun main(args: Array<String>) {

    var stringList = readLine()?.split(" ")?.toTypedArray() ?: return
    printArray(stringList, "Вывод массива")
    stringList.sort()
    printArray(stringList, "Вывод отсортированного массива")

    var arr = mutableListOf<String>()
    stringList.forEach { r ->
        if (!arr.contains(r))
            arr.add(r)
    }
    printArray(arr.toTypedArray(), "Уникальные значения")

    var texts = mutableListOf<TextList>() 
    stringList.forEach { r ->
        if  (texts.isEmpty() || texts.last().word != r){
            val countElements = stringList.count {it == r}
            texts.add(TextList(r, countElements))
        }
    }
    printArray(texts, "Количество уникальных")

    texts = sortByProperties(texts) 
    printArray(texts, "Сортировка уникальных")
     
}

private fun sortByProperties(array: MutableList<TextList>): MutableList<TextList> {
    val countElements = array.count {it.word == array.first().word}
    if (countElements == array.size)
        array.sortBy {it.word}
    else 
        array.sortBy {it.count}
    return array

}

private fun printArray(array: Array<String>, nameProcedure: String ) {
    println("---------------------")
    println(nameProcedure)
    println("---------------------")
    array.forEach { i -> 
        println(i)
    }
}

private fun printArray(array: MutableList<TextList>, nameProcedure: String ) {
    println("---------------------")
    println(nameProcedure)
    println("---------------------")
    array.forEach { elementOfList -> 
        println("${elementOfList.word} ${elementOfList.count}")
    }
}