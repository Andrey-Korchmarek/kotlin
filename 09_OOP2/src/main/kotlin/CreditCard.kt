open class CreditCard(money: Int, maxCredit: Int) : BankCard(money) {
    protected val creditLimit: Int
    protected var creditFunds: Int

    init {
        if (maxCredit > 0) { creditLimit = maxCredit }
        else { creditLimit = 0 }
        creditFunds = creditLimit
    }

    override fun topUp(money: Int) {
        TODO("Not yet implemented")
    }

    override fun pay(money: Int): Boolean {
        if (money > balance + creditFunds) return false
        else {
            balance -= money
            if (balance < 0) {
                creditFunds += balance
                balance = 0
                return true
            }
            else return true
        }
    }

    override fun balanceInfo() = println("Баланс карты - $balance")

    override fun fundsInfo() {
        TODO("Not yet implemented")
    }
}