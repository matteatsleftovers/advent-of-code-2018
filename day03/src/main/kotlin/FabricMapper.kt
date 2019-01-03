class FabricMapper(private val fabric: Fabric) {

    fun calculateAreaAtLeastTwiceClaimed(claims: Iterable<String>): Int {
        claims.forEach {
            val claim = convertStringToClaim(it)
            fabric.claim(claim.initialCoordinates.first,
                    claim.initialCoordinates.second,
                    claim.deltaCoordinates.first,
                    claim.deltaCoordinates.second)
        }

        return fabric.getTwiceOrMoreClaimedTiles()
    }

    fun convertStringToClaim(claimString: String): Claim {
        val splitStrings = claimString.split("#", "@", ",", ":", "x")
        val claimNumber = splitStrings[1].trim().toInt()
        val x0 = splitStrings[2].trim().toInt()
        val y0 = splitStrings[3].trim().toInt()
        val x = splitStrings[4].trim().toInt()
        val y = splitStrings[5].trim().toInt()

        return Claim(claimNumber, Pair(x0, y0), Pair(x, y))
    }

    fun getIntactClaim(claims: Iterable<String>): Int {
        val completedClaims: MutableList<Claim> = mutableListOf()
        claims.forEach {
            val claim = convertStringToClaim(it)
            val isIntact = fabric.check(claim.initialCoordinates.first,
                    claim.initialCoordinates.second,
                    claim.deltaCoordinates.first,
                    claim.deltaCoordinates.second)
            claim.intact = isIntact
            completedClaims.add(claim)
        }
        return completedClaims.filter { it.intact }[0].number
    }

}