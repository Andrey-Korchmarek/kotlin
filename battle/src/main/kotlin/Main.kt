import kotlin.random.Random

fun doNothing() {}

fun Int.chance(limit: Int = 100): Boolean =
    when{
        this <= 0 -> false
        limit <= 0 -> false
        this >= limit -> true
        else -> Random.nextInt(0 , limit) in (0 until this)
        //else -> (0 until limit).random() in (0 until this)
    }

fun main() {
    val test = Battle(Random.nextInt(1, 50))
    while (!test.battleIsOver) {
        test.battleIteration()
    }
    println("End of battle.")
}