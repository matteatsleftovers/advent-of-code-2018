class FabricMapper(private val fabric: Fabric) {

    fun calculateAreaAtLeastTwiceClaimed(claims: Iterable<String>): Int {
        claims.forEach {
            val coordinates = convertClaimToMeasurements(it)
            fabric.claim(coordinates.first.first,
                    coordinates.first.second,
                    coordinates.second.first,
                    coordinates.second.second)
        }

        return fabric.getTwiceOrMoreClaimedTiles()
    }

    fun convertClaimToMeasurements(claimString: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val splitStrings = claimString.split("@", ",", ":", "x")
        val x0 = splitStrings[1].trim().toInt()
        val y0 = splitStrings[2].trim().toInt()
        val x = splitStrings[3].trim().toInt()
        val y = splitStrings[4].trim().toInt()

        return Pair(Pair(x0, y0), Pair(x, y))
    }

}