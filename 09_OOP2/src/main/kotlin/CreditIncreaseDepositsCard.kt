class CreditIncreaseDepositsCard(money: Int, maxCredit: Int) : CreditCard(money, maxCredit) {
    protected val increasePercent: Double

    init {
        increasePercent = 0.005
    }

    override fun topUp(sum: Int) = super.topUp(sum + (sum * increasePercent).toInt())

    override fun fundsInfo() {
        println("Личных средств на карте $balance, доступно кредитных средств $creditFunds, накопление " +
                "${increasePercent * 100} процентов от суммы пополнений.")
    }
}