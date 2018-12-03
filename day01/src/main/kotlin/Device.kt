class Device {

    fun netFrequency(frequencies: Iterable<String>): Int {
        var sum = 0
        frequencies.forEach { it -> sum += it.toInt() }
        return sum
    }

    fun firstRepeatedFrequency(frequencies: Iterable<String>): Int {
        var sum = 0
        var sumResults = mutableListOf(sum)
        while(true) {
            frequencies.forEach { it ->
                sum += it.toInt()
                if (sumResults.contains(sum)) return sum
                else sumResults.add(sum)
            }
        }

        return sum
    }

}