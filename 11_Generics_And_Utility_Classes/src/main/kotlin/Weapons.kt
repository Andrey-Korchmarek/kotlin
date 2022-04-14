object Weapons {
    fun createPistol(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 12
        override fun createAmmo(): Ammo = Ammo.Special()
    }
    fun createRifle(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 1
        override fun createAmmo(): Ammo = Ammo.Hard()
    }
    fun createWeapon(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 40
        override var typeOfFire: FireType = FireType.BurstShot(8)
            set(value) { if (value != field) field = value}
        override fun createAmmo(): Ammo = Ammo.Usual()
        }

    fun createUzi(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 60
        override var typeOfFire: FireType = FireType.BurstShot(3)
        override fun createAmmo(): Ammo = Ammo.Simple()
    }
    fun createGatlinggun(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 200
        override var typeOfFire: FireType = FireType.AllOut
        override fun createAmmo(): Ammo = Ammo.Light()
    }
    fun createMedical(): AbstractWeapon = object : AbstractWeapon() {
        override val magazineSize: Int = 23
        override fun createAmmo(): Ammo = Ammo.Blank()
    }
    fun createRandomgun(): AbstractWeapon = object : AbstractWeapon(){
        override val magazineSize: Int = 100
        override fun createAmmo(): Ammo = Ammo.Lucky()
        init {
            reloading()
        }
    }
}
