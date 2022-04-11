class CreditIncreaseDepositsCard(money: Int, maxCredit: Int, increase: Int) : CreditCard(money, maxCredit) {
    private val increasePercent: Double
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, накопление ${String.format("%.2f", increasePercent * 100)} процентов от суммы пополнений" }

    init {
        if (increase in 0..100) { increasePercent = 0.0001 * increase }
        else { increasePercent = 0.0001 }
    }

    override fun topUp(sum: Int) = super.topUp(sum + (sum * increasePercent).toInt())
}