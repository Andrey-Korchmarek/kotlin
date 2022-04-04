fun main() {
    println("Hello World!")
    var test: Float = 21.0F
    when {
        test < 0.0F -> print("1 sector")
        test > 20.0F -> print("3 sector")
        else -> print("2 sector")
    }
}