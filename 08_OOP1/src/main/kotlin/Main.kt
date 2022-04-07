import kotlin.random.Random

fun any(vararg a: Boolean): Boolean = a.any { it }

fun main() {
    if (listOf<Boolean>(false, false, false).any {it}) println("Hello World!")

    val testAnimal= Animal("Тест", 100, 100, 100)
    for (i in (1..13)) {
        print("$i: ")
        listOf(
            { with(testAnimal) { eat() } },
            { testAnimal.move() },
            { testAnimal.sleep() },
        ).random()
    }
    println("Конец программы.")

}