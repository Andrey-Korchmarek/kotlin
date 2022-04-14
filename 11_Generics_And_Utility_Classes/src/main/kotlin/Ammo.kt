enum class Ammo(
    private val damage: Int,
    private val criticalChance: Int,
    private val criticalCoefficient: Int,
) {
    Light(1, 5, 10),
    Simple(10, 20, 5),
    Hard(50, 95, 2),
    Lucky(2, 1, 100),
    Special(1,1,1);

    fun getDamage(): Int = if (criticalChance.chance()) { criticalCoefficient * damage } else damage
}
