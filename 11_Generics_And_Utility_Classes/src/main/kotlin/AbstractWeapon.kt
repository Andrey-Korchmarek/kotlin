abstract class AbstractWeapon(private val magazineSize: Int) {
    open var typeOfFire: FireType = FireType.SingleShot
        set(value) { if (value != field) doNothing() else field = value }
    private var magazine: Stack<Ammo> = Stack()
    val magazineIsEmpty: () -> Boolean = { magazine.isEmpty() }

    abstract fun createAmmo(): Ammo
    fun reloading() {
        val newMagazine = Stack<Ammo>()
        (1..magazineSize).forEach { _ -> newMagazine.push(createAmmo()) }
        magazine = newMagazine
    }
    fun fire(): MutableList<Ammo> {
        val shots: MutableList<Ammo> = emptyList<Ammo>().toMutableList()
        typeOfFire.fire(magazine, shots)
        return shots
    }
}