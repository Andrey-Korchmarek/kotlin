abstract class AbstractWarrior : Warrior {
    abstract val maxHP: Int
    abstract override val dodgeChance: Int
    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon
    abstract var currentHP: Int
    override val isKilled: () -> Boolean = { (currentHP < 1) }

    override fun getDamage(damage: Int) { currentHP -= damage }
    override fun attack(enemy: Warrior) {
        if (weapon.magazineIsEmpty()) {
            weapon.reloading()
            //пропустить ход
        }
        else {
            weapon.fire()
            enemy.getDamage(0)
        }
    }
}