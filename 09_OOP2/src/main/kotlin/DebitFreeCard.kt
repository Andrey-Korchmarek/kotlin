class DebitFreeCard(money: Int, freeCriterion: Int) : DebitCard(money) {
    protected var expensesSum: Int

    init {
        if (freeCriterion > 0) { expensesSum = freeCriterion }
        else { expensesSum = Int.MAX_VALUE }
    }

    protected fun isFree(): Boolean = if (expensesSum <= 0) true else false

    override fun pay(money: Int): Boolean =
        if (super.pay(money)) {
            expensesSum -= money
            true
        }
        else false

    override fun fundsInfo() {
        print("Баланс карты $balance, ")
        if (isFree()) println("обслуживание в этом месяце бесплатно.")
        else println("до бесплатного обслуживания осталось потратить $expensesSum.")
    }
}