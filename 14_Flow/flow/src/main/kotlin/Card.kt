class Card(private val setOfCells: Set<Byte>) {
    private val cells: List<MutableMap<Byte, Boolean>> =
        setOfCells.shuffled().chunked(5).map { it.associateWith{ false }.toMutableMap() }
    private val stringOfCells: List<List<() -> String>> =
        cells.mapIndexed { index, mutableMap ->
            (mutableMap
                .keys
                .map { { if (cells[index][it]!!) "()" else it.toString().padStart(2, ' ') } }
                    + List(4) { { "  " } }
                    )
                .shuffled()
        }

    fun isWinner(): Boolean = cells.any { it -> it.values.all { it } }

    fun searchBarrel(barrel: Byte) {
        if (barrel in setOfCells) {
            when (barrel) {
                in cells[0].keys -> cells[0][barrel] = true
                in cells[1].keys -> cells[1][barrel] = true
                in cells[2].keys -> cells[2][barrel] = true
            }
        }
    }

    override fun toString(): String =
        stringOfCells.map { it.map {it()}.joinToString(" | ", "| ", " |") }
            .joinToString("\n${"-".repeat(46)}\n", "-".repeat(46) + "\n", "\n" + "-".repeat(46))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (setOfCells != other.setOfCells) return false

        return true
    }

    override fun hashCode(): Int {
        return setOfCells.hashCode()
    }
}