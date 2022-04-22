abstract class AbstractWarrior : Warrior {
    abstract val maxHP: Int
    abstract override var dodgeChance: Int
    abstract var accuracy: Int
    abstract val weapon: AbstractWeapon
    abstract var currentHP: Int
    override val isKilled: () -> Boolean = { (this.currentHP <= 0) }

    override fun takeDamage(damage: Int) {
        if (currentHP - damage >= maxHP) { currentHP = maxHP }
        else { currentHP -= damage }
    }
    override fun attack(enemy: Warrior): Boolean {
        try {
            enemy.takeDamage(
                weapon.fire().apply {
                    removeIf { !enemy.dodgeChance.chance() && accuracy.chance() }
                }
                    .sumOf { it.getDamage() }
            )
            return true
        } catch (e: NoAmmoException) {
            weapon.reloading()
            return false
        }
    }

    open fun specialAction(friend: AbstractWarrior) { //Specific action for this type of warrior
    }

    override fun toString(): String {
        return "${this.javaClass.toString()[6]}: HP ${this.currentHP}"
    }
}