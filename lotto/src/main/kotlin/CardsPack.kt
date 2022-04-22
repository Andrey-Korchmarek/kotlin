import kotlin.random.Random

object CardsPack {
    private lateinit var pack: Set<Set<Byte>>

    fun generatePack(size: ULong) {
        val tempPack = emptySet<Set<Byte>>().toMutableSet()
        while (tempPack.size.toULong() < size) {
            val temp = mutableSetOf<Byte>()
            while (temp.size < 15) {
                temp.add(Random.nextInt(1, 91).toByte())
            }
            tempPack.add(temp.toSet())
        }
        pack = tempPack.toSet()
    }
    fun getCard(): Card {
        val result: Card
        with(pack.random()) {
            result = Card(this)
            pack.minus(this)
        }
        return result
    }
}