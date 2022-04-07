import kotlin.random.Random

open class Animal(
    val name: String,
    val maxAge: Int,
    var energy: Int,
    var weight: Int,
) {
    val isTooOld: () -> Boolean
    protected var moveMessage: String
    protected var bornMessage: String
    private var currentAge: Int

    init {
        currentAge = 0
        isTooOld = { currentAge >= maxAge }
        moveMessage = "передвигается"
        bornMessage = "о животное"
    }

    fun sleep() {
        if (!isTooOld()) {
            energy += 5
            currentAge += 1
            println("$name спит.")
        }
    }

    fun eat() {
        if (!isTooOld()) {
            energy += 3
            weight += 1
            tryIncrementAge()
            println("$name ест.")
        }
    }

    open fun move() {
        if (!any(energy < 5, weight < 1, isTooOld())) {
            energy -= 5
            weight -= 1
            tryIncrementAge()
            println("$name $moveMessage.")
        }
    }

    open fun bear(): Animal {
        val newAnimal = Animal(this.name, this.maxAge, (1..10).random(), (1..5).random())
        println("Рожден$bornMessage ${newAnimal.name} весом ${newAnimal.weight} " +
                "с энергией ${newAnimal.energy} и максимальным возрастом ${newAnimal.maxAge}")
        return newAnimal
    }

    private fun tryIncrementAge() { if (Random.nextBoolean()) { currentAge += 1 } }
}