class BoxIdChecker {

    fun checkSum(strings: Iterable<String>): Int {
        return strings.sumBy { twoOf(it) } * strings.sumBy { threeOf(it) }
    }

    fun twoOf(string: String): Int {
        return nOf(string, 2)
    }

    fun threeOf(string: String): Int {
        return nOf(string, 3)
    }

    private fun nOf(string: String, n: Int): Int {
        val frequenciesOfEachChar = string.groupingBy { it }.eachCount()
        return if (frequenciesOfEachChar.containsValue(n)) 1 else 0
    }

    fun commonLetters(strings: Iterable<String>): String {
        var longestCommonSubsequence = ""

        val sortedStrings = strings.sorted()
        for (i in 1 until sortedStrings.size) {
            val localLcs = lcs(sortedStrings[i-1], sortedStrings[i])
            if (localLcs.length > longestCommonSubsequence.length) longestCommonSubsequence = localLcs
            println(longestCommonSubsequence)
        }

        return longestCommonSubsequence
    }

    /**
     * @return longest common subsequence (LCS), where we assume there is only one subsequence of the maximum length
     */
    fun lcs(a: String, b: String): String {
        val table: Array<Array<String>> = Array(a.length + 1) { Array(b.length + 1) { "" } }

        (1..a.length).forEach { i ->
            (1..b.length).forEach { j ->
                if (a[i - 1] == b[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + a[i - 1]
                } else {
                    table[i][j] = setOf(table[i][j - 1], table[i - 1][j]).maxBy { it.length }!!
                }
            }
        }

        return table[a.length][b.length]
    }

}