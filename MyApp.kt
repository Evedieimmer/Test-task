
data class TextList(
    val word: String,
    val count: Int
)

fun main(args: Array<String>) {
    printArray(args, "Вывод массива")
    args.sort()
    printArray(args, "Вывод отсортированного массива")

    var arr = mutableListOf<String>()
    args.forEach { r ->
        if (!arr.contains(r))
            arr.add(r)
    }
    printArray(arr.toTypedArray(), "Уникальные значения")

    var texts = mutableListOf<TextList>() 
    args.forEach { r ->
        if  (texts.isEmpty() || texts.last().word != r){
            val countElements = args.count {it == r}
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