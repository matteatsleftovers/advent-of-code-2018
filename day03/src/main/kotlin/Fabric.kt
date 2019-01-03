class Fabric(private val width: Int, private val height: Int) {

    private val table: Array<Array<Tile>> = Array(height) { Array(width) { Tile.FRESH } }

    fun claim(x0: Int, y0: Int, x: Int, y: Int) {
        (x0 until x+x0).forEach { i ->
            (y0 until y+y0).forEach { j ->
                table[i][j] = table[i][j].claim()
            }
        }
    }

    fun check(x0: Int, y0: Int, x: Int, y: Int): Boolean {
        var isIntact = true
        (x0 until x+x0).forEach { i ->
            (y0 until y+y0).forEach { j ->
                if (table[i][j] == Tile.CLAIMED_TWICE_OR_MORE) isIntact = false
            }
        }
        return isIntact
    }

    fun getTwiceOrMoreClaimedTiles(): Int {
        var numberTwiceOrMoreClaimed = 0
        (0 until width).forEach { i ->
            (0 until height).forEach { j ->
                if (table[i][j] == Tile.CLAIMED_TWICE_OR_MORE) numberTwiceOrMoreClaimed++
            }
        }
        return numberTwiceOrMoreClaimed
    }
}