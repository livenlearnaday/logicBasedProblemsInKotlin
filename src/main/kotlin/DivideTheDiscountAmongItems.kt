import java.math.BigDecimal
import java.math.RoundingMode


fun main(args: Array<String>) {

    // Any remainder is to be added to the first product
    val totalDiscount1 = 13.0
    val pricesOfItems1 = intArrayOf(12, 12, 15)
    println(
        "resultingDiscountedPrices ::: pricesOfItems1 :::: ${
            resultingDiscountedPrices(
                pricesOfItems1,
                totalDiscount1
            ).contentToString()
        }"
    )

// Any remainder is to be added to the first product
    val totalDiscount2 = 13.0
    val pricesOfItems2 = intArrayOf(12, 12)
    println(
        "resultingDiscountedPrices ::: pricesOfItems2 :::: ${
            resultingDiscountedPrices(
                pricesOfItems2,
                totalDiscount2
            ).contentToString()
        }"
    )


}

fun resultingDiscountedPrices(arrInput: IntArray, totalDiscount: Double): Array<Double> {

    val arrayWithDiscountedPrice = mutableListOf<Double>()
    var remainder = 0.0
    val discountPerItem: Double
    var firstItemDiscount = 0.0

    println("total Discount / items qty = ${totalDiscount / arrInput.size}")

    if (totalDiscount % arrInput.size != 0.0 && !checkIfSecondDecimalPlaceIsExactlyHalf(totalDiscount / arrInput.size)) {

        discountPerItem = roundedToDefinedDecimalPlaces((totalDiscount / arrInput.size), 0)

        if (discountPerItem * arrInput.size < totalDiscount) {
            remainder = totalDiscount - (discountPerItem * arrInput.size)
            println("remainer = $remainder")
        }

        println("discountPerItem = $discountPerItem")
        firstItemDiscount = discountPerItem + remainder
        println("firstItemDiscount = $firstItemDiscount")
    } else {
        discountPerItem = totalDiscount / arrInput.size
    }


    for (i in 0 until arrInput.size) {
        if (i == 0 && !checkIfSecondDecimalPlaceIsExactlyHalf(totalDiscount / arrInput.size)) {
            arrayWithDiscountedPrice.add((arrInput[0] - firstItemDiscount))
        } else {
            arrayWithDiscountedPrice.add(arrInput[i] - discountPerItem)
        }
    }

    return arrayWithDiscountedPrice.toTypedArray()
}


fun roundedToDefinedDecimalPlaces(amt: Double, decimalPlaces: Int): Double {
    val bd = BigDecimal(amt)
    return bd.setScale(decimalPlaces, RoundingMode.FLOOR).toDouble()
}

fun checkIfSecondDecimalPlaceIsExactlyHalf(num: Double): Boolean {
    val bd = BigDecimal(num)
    val decimalNumberWithNoTrailingZeros = bd.stripTrailingZeros()
    val pattern = Regex("^[0-9]+([.][5]{1})?\$")
    if (pattern.containsMatchIn(decimalNumberWithNoTrailingZeros.toString())) {
        return true
    }
    return false
}

