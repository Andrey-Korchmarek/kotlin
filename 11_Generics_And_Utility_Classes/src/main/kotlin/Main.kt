fun Int.chance(limit: Int = 100): Boolean =
    when{
        this <= 0 -> false
        limit <= 0 -> false
        this >= limit -> true
        else -> (0 until limit).random() in (0 until this)
    }

fun main() {
    var test = Stack(1, 2, 3, 4, 5)
    println(test.isEmpty())
    while (!test.isEmpty()) println(test.pop())
    println(test.isEmpty())
    println("Конец программы.")
}