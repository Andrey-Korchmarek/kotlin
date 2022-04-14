class Captain : AbstractWarrior() {
        override val maxHP: Int = 10
        override val dodgeChance: Int = 95
        override val accuracy: Int = 95
        override val weapon: AbstractWeapon = Weapons.createPistol()
}

class Sniper : AbstractWarrior() {
        override val maxHP: Int = 90
        override val dodgeChance: Int = 5
        override val accuracy: Int = 99
        override val weapon: AbstractWeapon = Weapons.createRifle()
}

class Soldier : AbstractWarrior() {
        override val maxHP: Int = 80
        override val dodgeChance: Int = 80
        override val accuracy: Int = 80
        override val weapon: AbstractWeapon = Weapons.createWeapon()
}

class Trinity : AbstractWarrior() {
        override val maxHP: Int = 120
        override val dodgeChance: Int = 66
        override val accuracy: Int = 90
        override val weapon: AbstractWeapon = Weapons.createUzi()
}

class Terminator : AbstractWarrior() {
        override val maxHP: Int = 400
        override val dodgeChance: Int = 0
        override val accuracy: Int = 50
        override val weapon: AbstractWeapon = Weapons.createGatlinggun()
}

class Medic : AbstractWarrior() {
        override val maxHP: Int = 100
        override val dodgeChance: Int = 95
        override val accuracy: Int = 100
        override val weapon: AbstractWeapon = Weapons.createMedical()
}

class Joker : AbstractWarrior() {
        override val maxHP: Int = 111
        override val dodgeChance: Int = 50
        override val accuracy: Int = 100
        override val weapon: AbstractWeapon = Weapons.createRandomgun()
        override val isKilled: () -> Boolean = weapon.magazineIsEmpty
}
