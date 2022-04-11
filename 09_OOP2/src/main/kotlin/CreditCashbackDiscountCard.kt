class CreditCashbackDiscountCard(money: Int,
                                 maxCredit: Int,
                                 cashback: Int,
) : CreditCard(money, maxCredit) {
    private var discount: Int
    private val discountPercent: Double
    override val infoMessage: () -> String
        get() = { "${super.infoMessage()}, скидка на следующую покупку $discount" }

    init {
        discount = 0
        if (cashback in (0..100)) { discountPercent = cashback * 0.01 }
        else discountPercent = 0.01
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
}