abstract class AbstractWarrior : Warrior {
    abstract val maxHP: Int
    abstract override val dodgeChance: Int
    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon
    var currentHP: Int = maxHP
    override val isKilled: () -> Boolean = { (this.currentHP < 1) }

    override fun getDamage(damage: Int) { currentHP -= damage }
    override fun attack(enemy: Warrior) {
        if (!weapon.magazineIsEmpty())
            enemy.getDamage(
                weapon.fire().apply {
                    removeIf { !enemy.dodgeChance.chance() && accuracy.chance() }
                }
                    .sumOf { it.getDamage() }
            )
        else {
            weapon.reloading()
            //пропустить ход
        }
    }
}