class Player(val name: String?, count: ULong) {
    val cards: List<Card>
    init {
        val tempCards = mutableListOf<Card>()
        while (tempCards.size.toULong() < count) {
            tempCards.add(CardsPack.getCard())
        }
        cards = tempCards.shuffled()
    }

    override fun toString(): String = "${name}${cards.joinToString("\n", "\n")}"
}