class CreditBonusCard(money: Int, maxCredit: Int, cashback: Int) : CreditCard(money, maxCredit) {
    protected var bonusPoints: Int
    protected val bonusPercent: Double

    init {
        bonusPoints = 0
        if (cashback in 0..100) { bonusPercent = cashback * 0.01 }
        else { bonusPercent = 0.0 }
    }

    override fun pay(sum: Int): Boolean =
        if (super.pay(sum)) {
            bonusPoints += (sum * bonusPercent).toInt()
            true
        }
        else false

    fun payWithBonuses(sum: Int): Boolean =
        if (sum < 0 || bonusPoints < sum) false
        else {
            bonusPoints -= sum
            false
        }

    override fun balanceInfo() {
        println("Личных средств на карте $balance, доступно кредитных средств $creditFunds, бонусов $bonusPoints.")
    }
}