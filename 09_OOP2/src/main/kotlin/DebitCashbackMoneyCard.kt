class DebitCashbackMoneyCard(money: Int, cashback: Int) : DebitCard(money) {

    private val refundPercent: Double
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, кэшбэк ${(refundPercent * 100).toInt()} процентов" }

    init {
        if (cashback in (0..100)) { refundPercent = cashback * 0.01 }
        else refundPercent = 0.01
    }

    private fun cashback(sum: Int) {
        balance += (sum * refundPercent).toInt()
    }

    override fun pay(sum: Int): Boolean =
        if (super.pay(sum)) {
            cashback(sum)
            true
        }
        else false
}