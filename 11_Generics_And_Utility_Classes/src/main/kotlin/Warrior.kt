interface Warrior {
    val isKilled: () -> Boolean
    val dodgeChance: Int

    fun attack(enemy: Warrior)
    fun getDamage(damage: Int)
}