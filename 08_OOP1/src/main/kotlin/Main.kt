
fun or(vararg a: Boolean): Boolean {
    return a.any { it }
}

fun main() {
    if (listOf<Boolean>(true, false, true).any()) println("Hello World!")

}