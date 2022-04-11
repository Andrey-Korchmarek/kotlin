class CreditCashbackBonusCard(money: Int, maxCredit: Int, cashback: Int) : CreditCard(money, maxCredit) {
    private var bonusPoints: Int
    private val bonusPercent: Double
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, у вас есть $bonusPoints бонусов" }

    init {
        bonusPoints = 0
        if (cashback in 0..100) { bonusPercent = cashback * 0.01 }
        else { bonusPercent = 0.01 }
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
}