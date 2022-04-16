interface Warrior {
    val isKilled: () -> Boolean
    var dodgeChance: Int

    fun attack(enemy: Warrior)
    fun takeDamage(damage: Int)
}