class MtGCard(createArgument: String = "Test") {
    internal val id: UInt
    val name: String
        get() = if (isOpen) field else "face down"
    val manacost: String?
        get() = if (isOpen) field else null
    val rarity: Char
        get() = if (isOpen) field else '#'
    val text: String
        get() = if (isOpen) field else ""
    private var isOpen: Boolean

    init {
        id = 0U
        name = createArgument
        isOpen = false
        manacost = null
        rarity = '_'
        text = ""
    }

    fun turnCard() = run { isOpen = !isOpen }
}