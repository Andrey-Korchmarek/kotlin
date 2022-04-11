class CreditCashbackDiscountCard(money: Int,
                                 maxCredit: Int,
                                 cashback: Int,
) : CreditCard(money, maxCredit) {
    protected var discount: Int
    protected val discountPercent: Double

    init {
        discount = 0
        if (cashback in (0..100)) { discountPercent = cashback * 0.01 }
        else discountPercent = 0.0
    }

    override fun pay(sum: Int): Boolean {
        var temp = sum
        temp -= discount
        if (super.pay(temp).not()) return false
        else {
            discount = (temp * discountPercent).toInt()
            return true
        }
    }

    override fun balanceInfo() {
        println("Личных средств на карте $balance, доступно кредитных средств $creditFunds, скидка на следующую " +
                "покупку $discount.")
    }
}