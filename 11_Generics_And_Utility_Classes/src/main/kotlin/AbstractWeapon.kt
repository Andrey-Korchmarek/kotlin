abstract class AbstractWeapon {
    abstract val magazineSize: Int
    protected open var typeOfFire: FireType = FireType.SingleShot
        set(value) {}
    var magazine: Stack<Ammo> = Stack()
    val magazineIsEmpty: () -> Boolean = { magazine.isEmpty() }

    abstract fun createAmmo(): Ammo
    fun reloading() {
        val newMagazine = Stack<Ammo>()
        (1..magazineSize).forEach { _ -> newMagazine.push(createAmmo()) }
        magazine = newMagazine
    }
    fun fire(): List<Ammo> {
        val shots = mutableListOf<Ammo>(Ammo.Blank)
        typeOfFire.fire(magazine, shots)
        return shots.toList()
    }
}