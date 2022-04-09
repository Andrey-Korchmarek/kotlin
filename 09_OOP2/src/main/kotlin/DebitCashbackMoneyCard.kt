class DebitCashbackMoneyCard(money: Int, cashback: Int) : DebitCard(money) {

    protected val refundPercent: Double

    init {
        if (cashback in (0..100)) { refundPercent = cashback * 0.01 }
        else refundPercent = 0.00
    }

    protected fun cashback(sum: Int) {
        balance += (sum * refundPercent).toInt()
    }

    override fun pay(money: Int): Boolean =
        if (super.pay(money)) {
            cashback(money)
            true
        }
        else false

    override fun fundsInfo() = println("Баланс карты $balance, кэшбэк ${(refundPercent * 100).toInt()}} процентов.")
}