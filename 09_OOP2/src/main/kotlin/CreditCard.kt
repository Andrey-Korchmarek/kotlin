open class CreditCard(money: Int, maxCredit: Int = 5000) : BankCard(money) {
    protected val creditLimit: Int

    init {
        creditLimit = maxCredit
    }

    override fun topUp(money: Int) {
        TODO("Not yet implemented")
    }

    override fun pay(money: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun balanceInfo() {
        TODO("Not yet implemented")
    }

    override fun fundsInfo() {
        TODO("Not yet implemented")
    }
}