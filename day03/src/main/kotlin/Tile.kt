enum class Tile {
    FRESH {
        override fun claim(): Tile {
            return CLAIMED_ONCE
        }
    }, CLAIMED_ONCE {
        override fun claim(): Tile {
            return CLAIMED_TWICE_OR_MORE
        }
    }, CLAIMED_TWICE_OR_MORE {
        override fun claim(): Tile {
            return CLAIMED_TWICE_OR_MORE
        }
    };

    abstract fun claim(): Tile
}