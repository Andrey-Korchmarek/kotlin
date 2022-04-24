fun main(args: Array<String>) {
    //println("Hello World!") Это однострочный комментарий
    val itsValue: Int
    var itsVariable: String?

    try {
        itsValue = args[0].toInt()
        itsVariable = args[2]
    } catch (e: NumberFormatException) {
        (-1).also { itsValue = it }
        itsVariable = "Первым аргументом должно быть целое число!"
        println(itsVariable)
    } catch (e: ArrayIndexOutOfBoundsException) {
        itsValue = 0
        print("Введите значение переменной - ")
        itsVariable = readLine()
        println("А теперь ещё раз:")
        itsVariable = readLine()
    } finally {
        itsVariable = null
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")
}