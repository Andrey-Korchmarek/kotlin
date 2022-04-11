class DebitCashbackConstCard(money: Int, cashback: Int) : DebitCard(money) {
    private val refundConst: Int
    private val refundStart: Int
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, кэшбэк $refundConst при покупке от $refundStart" }

    init {
        if (cashback >= 0) refundConst = cashback
        else refundConst = 1
        refundStart = refundConst * 10
    }

    private fun cashback(sum: Int) {
        if (refundStart <= sum) { balance += refundConst }
    }

    override fun pay(sum: Int): Boolean =
        if (super.pay(sum)) {
            cashback(sum)
            true
        }
        else false
}