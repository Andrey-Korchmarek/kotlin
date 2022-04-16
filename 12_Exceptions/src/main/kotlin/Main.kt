fun main() {
    val test = Wheel()
    try {
        test.pumpUp(11.0)
    } catch (e: IncorrectPressure) {
        println("Накачка не удалась.")
    } finally {
        test.pumpUp(5.0)
    }
    try {
        test.checkPressure()
    } catch (e: TooHighPressure) {
        println("Ехать нельзя - колесо перекачано.")
    } finally {
        test.pumpUp(0.5)
    }
    try {
        test.checkPressure()
    } catch (e: TooLowPressure) {
        println("Ехать нельзя - колесо недокачано.")
    } finally {
        test.pumpUp(2.0)
        test.checkPressure()
    }
    println("Конец программы.")
}