class Wheel {
    private var currentPressure: Double = 0.0

    fun pumpUp(target: Double) {
        if (target < 0.0 || target > 10.0) { throw IncorrectPressure() }
        else { currentPressure = target }
    }
    fun checkPressure() {
        when {
            currentPressure < 1.6 -> throw TooLowPressure()
            currentPressure > 2.5 -> throw TooHighPressure()
            else -> println("Нормальное давление - можно ехать.")
        }
    }
}