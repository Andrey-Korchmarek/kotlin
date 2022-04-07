fun any(vararg args: Boolean): Boolean = args.any { it }

fun main() {
    if (listOf<Boolean>(false, false, false).any {it}) {
        println("Hello World!")

    }
    val testNature = NatureReserve()
    loop@for (i in (1..21)) {
        println("Начался $i цикл жизни в заповеднике.")
        testNature.oneTime()
        if (testNature.elements.size == 0) {
            println("К сожалению все животные покинули нас :(")
            break@loop
        }
        println("$i цикл жизни в заповеднике закончился.")
    }
    println("В заповеднике осталось ${testNature.elements.size} животных.")
    println("Конец программы.")


}