enum class Ammo(
    private val damage: Int,
    private val criticalChance: Int,
    private val criticalCoefficient: Int,
) {
    Light(1, 5, 10),
    Simple(10, 20, 5),
    Hard(50, 95, 2),
    Usual(6,25,5),
    Special(5,50,10),
    Lucky(2, 1, 100),
    Blank(0, 0, 0) ;

    fun getDamage(): Int = if (criticalChance.chance()) { criticalCoefficient * damage } else damage

    override fun toString(): String =
        "ammo ${this.name}(d: ${this.damage}, ${this.criticalChance}%, x${this.criticalCoefficient})"

    operator fun <T : Ammo> invoke(): T =
        when(this) {
            Light -> Light()
            Simple -> Simple()
            else -> Special()
        }

}
