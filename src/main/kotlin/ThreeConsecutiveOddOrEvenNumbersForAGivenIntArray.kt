
fun main(args: Array<String>) {

    val numArray = intArrayOf(1, 2, 3, 4, 5, 6)
    val numArrayHas3ConsecutiveEvenNumbers = intArrayOf(12, 2, 6, 4, 5, 6)
    val numArrayHas3ConsecutiveOddNumbers = intArrayOf(1, 2, 3, 7, 5, 6)
    val numArrayHas3ConsecutiveOddAndEvenNumbers = intArrayOf(12, 4, 2, 7, 5, 9)
    val numArrayIsEmpty = intArrayOf()

    println("numArray : ${checkArrayIfHasConsecutiveOddOrEvenNumber(numArray)}")
    println("numArrayHas3ConsecutiveEvenNumbers: ${checkArrayIfHasConsecutiveOddOrEvenNumber(numArrayHas3ConsecutiveEvenNumbers)}")
    println("numArrayHas3ConsecutiveOddNumbers: ${checkArrayIfHasConsecutiveOddOrEvenNumber(numArrayHas3ConsecutiveOddNumbers)}")
    println("numArrayHas3ConsecutiveOddAndEvenNumbers: ${checkArrayIfHasConsecutiveOddOrEvenNumber(numArrayHas3ConsecutiveOddAndEvenNumbers)}")
    println("numArrayIsEmpty: ${checkArrayIfHasConsecutiveOddOrEvenNumber(numArrayIsEmpty)}")

}


fun checkArrayIfHasConsecutiveOddOrEvenNumber(numArray: IntArray):Boolean {
    if (numArray.isEmpty() || numArray.size < 3) return false
    val oddNumbersArray = mutableListOf<Int>()
    val evenNumbersArray = mutableListOf<Int>()
    numArray.forEachIndexed { index, num ->
        if (num % 2 == 0) {
            evenNumbersArray.add(index)
        } else {
            oddNumbersArray.add(index)
        }
    }
    if(checkIfIndexAreConsecutive(evenNumbersArray) || checkIfIndexAreConsecutive(oddNumbersArray)){
        return true
    }
    return false
}

fun checkIfIndexAreConsecutive (arrayInput: MutableList<Int>): Boolean {
    val array = arrayInput.sorted().toMutableList()
    var counter = 0

    for (i in 0 until array.size) {
        if(i > 0) {
            if (array[i] == (array[i-1] + 1)) {
                counter++
                if (counter == 2) {
                    return true
                }
            }
        }
    }
    return false
}



