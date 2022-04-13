fun main() {
    val test: MutableSet<String> = emptySet<String>().toMutableSet()
    CurrencyRate.values().forEach { test.add(it.name) }
    test.addAll(setOf("^_^", "USA", "XYZ", "ABC", "TST"))
    test.shuffled().forEach { it ->
        println(it)
        val temp = Converters.get(it)
        val numbers = listOf(1, 1000000000, (1..Int.MAX_VALUE).random())
        numbers.forEach { println("$it RUB = ${temp.convertToRub(it)} ${temp.currencyCode}") }
    }
    println("Конец программы.")
}