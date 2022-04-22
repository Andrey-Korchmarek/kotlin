object Weapons {
    fun createPistol(): AbstractWeapon = object : AbstractWeapon(12) {
        override fun createAmmo(): Ammo = Ammo.Special
    }
    fun createRifle(): AbstractWeapon = object : AbstractWeapon(1) {
        override fun createAmmo(): Ammo = Ammo.Hard
    }
    fun createWeapon(): AbstractWeapon = object : AbstractWeapon(40) {
        override var typeOfFire: FireType = FireType.BurstShot(8)
            set(value) { if (value != field) { field = value } else doNothing() }
        override fun createAmmo(): Ammo = Ammo.Usual
    }
    fun createUzi(): AbstractWeapon = object : AbstractWeapon(60) {
        override var typeOfFire: FireType = FireType.BurstShot(12)
        override fun createAmmo(): Ammo = Ammo.Simple
    }
    fun createGatlinggun(): AbstractWeapon = object : AbstractWeapon(200) {
        override var typeOfFire: FireType = FireType.AllOut
        override fun createAmmo(): Ammo = Ammo.Light
    }
    fun createMedical(): AbstractWeapon = object : AbstractWeapon(23) {
        override fun createAmmo(): Ammo = Ammo.Blank
    }
    fun createRandomgun(): AbstractWeapon = object : AbstractWeapon(100){
        override fun createAmmo(): Ammo = Ammo.Lucky
    }
}
