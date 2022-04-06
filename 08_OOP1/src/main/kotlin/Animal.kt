import kotlin.random.Random

class Animal(
    val name: String,
    val maxAge: Int,
    var energy: Int,
    var weight: Int,
) {
    var currentAge: Int
    val isTooOld: () -> Boolean

    init {
        currentAge = 0
        isTooOld = { currentAge >= maxAge }
    }

    fun sleep() {
        if (!isTooOld()) {
            energy += 5
            currentAge += 1
            println("$name спит.")
        } else {}
    }

    fun eat() {
        if (!isTooOld()) {
            energy += 3
            weight += 1
            tryIncrementAge()
            println("$name ест.")
        } else {}
    }

    fun move() {
        if (listOf<Boolean>(energy < 5, weight < 1, isTooOld()).any()) {}
        else {
            energy -= 5
            weight -= 1
            tryIncrementAge()
            println("$name передвигается.")
        }
    }

    fun bear() {

    }

    protected fun tryIncrementAge(): Unit { if (Random.nextBoolean()) { currentAge += 1 } else {} }
}