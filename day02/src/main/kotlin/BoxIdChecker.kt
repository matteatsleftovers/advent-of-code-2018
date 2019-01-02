class BoxIdChecker {

    fun checkSum(strings: Iterable<String>): Int {
        return strings.sumBy { twoOf(it) } * strings.sumBy { threeOf(it) }
    }

    fun twoOf(string: String): Int {
        val frequenciesOfEachChar = string.groupingBy { it }.eachCount()
        return if (frequenciesOfEachChar.containsValue(2)) 1 else 0
    }

    fun threeOf(string: String): Int {
        val frequenciesOfEachChar = string.groupingBy { it }.eachCount()
        return if (frequenciesOfEachChar.containsValue(3)) 1 else 0
    }

}