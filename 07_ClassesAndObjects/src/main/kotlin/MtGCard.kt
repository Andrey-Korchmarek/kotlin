class MtGCard(createArgument: String = "Test") {
    internal val id: UInt
    val name: String
        get() = if (isOpen) field else Shirt.name
    val manacost: String?
        get() = if (isOpen) field else Shirt.manacost
    val rarity: Char
        get() = if (isOpen) field else Shirt.rarity
    val text: String
        get() = if (isOpen) field else Shirt.text
    private var isOpen: Boolean

    init {
        id = 0U
        name = createArgument
        isOpen = false
        manacost = null
        rarity = '_'
        text = ""
        println("Объект карточка МТГ с id $id и кодом ${this.hashCode()} создан!")
    }

    fun readCard() = println("Card $name with mana cost $manacost, rarity $rarity and text $text.")

    fun turnCard() = run { isOpen = !isOpen }

    companion object Shirt {
        const val name: String = "face down"
        val manacost: String? = null
        const val rarity: Char = '#'
        const val text: String =  ""
    }
}