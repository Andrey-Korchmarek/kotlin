abstract class AbstractWeapon(val magazineSize: Int) {
    open var typeOfFire: FireType = FireType.SingleShot
        set(value) {}
    var magazine: Stack<Ammo> = Stack()
    val magazineIsEmpty: () -> Boolean = { magazine.isEmpty() }

    abstract fun createAmmo(): Ammo
    fun reloading() {
        val newMagazine = Stack<Ammo>()
        (1..magazineSize).forEach { _ -> newMagazine.push(createAmmo()) }
        magazine = newMagazine
    }
    fun fire(): MutableList<Ammo> {
        val shots = mutableListOf<Ammo>(Ammo.Blank)
        typeOfFire.fire(magazine, shots)
        return shots
    }
}