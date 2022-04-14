import kotlin.random.Random

fun Int.chance(limit: Int = 100): Boolean =
    when{
        this <= 0 -> false
        limit <= 0 -> false
        this >= limit -> true
        else -> Random.nextInt(0 , limit) in (0 until this)
        //else -> (0 until limit).random() in (0 until this)
    }

fun main() {
    /*var test = Stack<Int?>(1, 2, null, 3, 4, null, 6, 7)
    println(test)
    println(test.isEmpty())
    while (!test.isEmpty()) println(test.pop() ?: "")
    println(test.isEmpty())*/

    val test2 = Stack<Ammo>(*Ammo.values())
    println(test2)
    val shots = emptyList<Ammo>().toMutableList()
    while (!test2.isEmpty()) { shots.add(test2.pop() ?: Ammo.Blank) }
    shots[3] = Ammo.Blank
    shots.add(Ammo.Blank)
    println(shots)
    shots.removeIf { it.name == "Blank" }
    println(shots)
    println("Конец программы.")
}