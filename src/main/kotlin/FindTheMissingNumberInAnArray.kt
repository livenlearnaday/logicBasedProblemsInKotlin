fun main(args: Array<String>) {
    val arr5NumMissing4 = intArrayOf(2, 1, 6, 3, 5)
    println("arr5NumMissing4 ::: findMissingNumMethod1 :::: ${findMissingNumMethod1(arr5NumMissing4)}")


    val arr6NumMissing2 = intArrayOf(7, 1, 6, 3, 5, 4)
    println("arr6NumMissing2 ::: findMissingNumMethod1 :::: ${findMissingNumMethod1(arr6NumMissing2)}")


    val arr3NumMissing4 = intArrayOf(3, 2, 5)
    println("arr3NumMissing4 ::: findMissingNumMethod1 :::: ${findMissingNumMethod1(arr3NumMissing4)}")


}

fun findMissingNumMethod1(arrInput: IntArray): Int {
    val listOfHashMap = arrayListOf<HashMap<Int,Boolean>>()

    var missingNum = 0

    if(arrInput.isNotEmpty() && arrInput.size > 2) {

        val sortedArr = arrInput.sorted()

        for (i in 0 until sortedArr.size) {
            val map = HashMap<Int, Boolean>()
            if(i > 0) {
                map.put(sortedArr[i], (sortedArr[i] - sortedArr[i - 1] == 1))
                listOfHashMap.add(map)
            }
        }


        for(i in 0 until listOfHashMap.size){
            println("map in listOfHashMap $listOfHashMap[i]")
            if(listOfHashMap[i].containsValue(false)){
                missingNum = listOfHashMap[i].keys.first() -1
            }
        }

    }

    return missingNum

}

