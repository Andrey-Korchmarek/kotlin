sealed class FireType {
    object SingleShot: FireType() {
        override fun fire(magazine: Stack<Ammo>, shots: MutableList<Ammo>) {
            shots.add(magazine.pop() ?: throw NoAmmoException())
        }
    }
    data class BurstShot(val burstSize: Int): FireType() {
        override fun fire(magazine: Stack<Ammo>, shots: MutableList<Ammo>) {
            repeat((1..burstSize).count()) { shots.add(magazine.pop() ?: throw NoAmmoException()) }
        }
    }
    object AllOut: FireType() {
        override fun fire(magazine: Stack<Ammo>, shots: MutableList<Ammo>) {
            while (!magazine.isEmpty()) { shots.add(magazine.pop() ?: throw NoAmmoException()) }

        }
    }
    open fun fire(magazine: Stack<Ammo>, shots: MutableList<Ammo>) {}
}
