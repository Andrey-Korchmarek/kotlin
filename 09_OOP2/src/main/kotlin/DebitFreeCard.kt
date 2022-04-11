class DebitFreeCard(money: Int, freeCriterion: Int) : DebitCard(money) {
    private var expensesSum: Int
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, ${
            if (isFree()) "обслуживание в этом месяце бесплатно" 
            else "до бесплатного обслуживания осталось потратить $expensesSum"
        }" }

    init {
        if (freeCriterion >= 0) { expensesSum = freeCriterion }
        else { expensesSum = Int.MAX_VALUE }
    }

    private fun isFree(): Boolean = (expensesSum <= 0)

    override fun pay(sum: Int): Boolean =
        if (super.pay(sum)) {
            expensesSum -= sum
            true
        }
        else false
}