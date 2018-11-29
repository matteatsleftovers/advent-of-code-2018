class Device {

    fun netFrequency(frequencies: Iterable<String>): Int {
        var sum = 0
        frequencies.forEach { it -> sum += it.toInt() }
        return sum
    }

}