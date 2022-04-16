class Captain : AbstractWarrior() {
        override val maxHP: Int = 10
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 95
        override var accuracy: Int = 95
        override val weapon: AbstractWeapon = Weapons.createPistol()
        override fun specialAction(friend: AbstractWarrior) { //Raises morale of allies
                if (friend is Captain) { println("Captain already motivated.") }
                else {
                        friend.dodgeChance += 1
                        friend.accuracy += 1
                        println("Captain motivates an ally.")
                }
        }
}

class Sniper : AbstractWarrior() {
        override val maxHP: Int = 90
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 5
        override var accuracy: Int = 99
        override val weapon: AbstractWeapon = Weapons.createRifle()
}

class Fighter : AbstractWarrior() {
        override val maxHP: Int = 80
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 80
        override var accuracy: Int = 80
        override val weapon: AbstractWeapon = Weapons.createWeapon()
        override fun specialAction(friend: AbstractWarrior) { //Switch the firing type
                when (weapon.typeOfFire) {
                        is FireType.BurstShot -> weapon.typeOfFire = FireType.SingleShot
                        is FireType.SingleShot -> weapon.typeOfFire = FireType.AllOut
                        is FireType.AllOut -> weapon.typeOfFire = FireType.BurstShot(8)
                }
        }
}

class Rowdy : AbstractWarrior() {
        override val maxHP: Int = 120
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 65
        override var accuracy: Int = 90
        override val weapon: AbstractWeapon = Weapons.createUzi()
}

class Terminator : AbstractWarrior() {
        override val maxHP: Int = 400
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 0
        override var accuracy: Int = 35
        override val weapon: AbstractWeapon = Weapons.createGatlinggun()
}

class Medic : AbstractWarrior() {
        override val maxHP: Int = 100
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 95
        override var accuracy: Int = 100
        override val weapon: AbstractWeapon = Weapons.createMedical()
        override fun specialAction(friend: AbstractWarrior) { //Healing allies
                friend.takeDamage(-10)
                println("Medic healed an ally.")
        }
}

class Joker : AbstractWarrior() {
        override val maxHP: Int = 111
        override var currentHP: Int = maxHP
        override var dodgeChance: Int = 50
        override var accuracy: Int = 100
        override val weapon: AbstractWeapon = Weapons.createRandomgun()
        override val isKilled: () -> Boolean = {(currentHP <= 0) || weapon.magazineIsEmpty()}
        init {
                weapon.reloading()
        }
}
