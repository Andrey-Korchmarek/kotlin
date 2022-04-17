interface Warrior {
    val isKilled: () -> Boolean
    var dodgeChance: Int

    fun attack(enemy: Warrior): Boolean
    fun takeDamage(damage: Int)
}