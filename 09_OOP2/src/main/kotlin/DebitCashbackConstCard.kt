class DebitCashbackConstCard(money: Int, cashback: Int) : DebitCard(money) {
    protected val refundConst: Int
    protected val refundStart: Int

    init {
        if (cashback > 0) refundConst = cashback
        else refundConst = 0
        refundStart = refundConst * 10
    }

    protected fun cashback(sum: Int) {
        if (refundStart <= sum) { balance += refundConst }
        else {}
    }

    override fun pay(money: Int): Boolean =
        if (super.pay(money)) {
            cashback(money)
            true
        }
        else false

    override fun fundsInfo() = println("Баланс карты $balance, кэшбэк $refundConst при покупке от $refundStart.")
}