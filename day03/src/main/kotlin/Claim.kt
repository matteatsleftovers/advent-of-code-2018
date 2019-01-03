data class Claim(
        val number: Int,
        val initialCoordinates: Pair<Int, Int>,
        val deltaCoordinates: Pair<Int, Int>,
        var intact: Boolean = true
)