open class CreditCard(money: Int, maxCredit: Int) : BankCard(money) {
    protected val creditLimit: Int
    protected var creditFunds: Int

    init {
        if (maxCredit > 0) { creditLimit = maxCredit }
        else { creditLimit = 0 }
        creditFunds = creditLimit
    }

    override fun topUp(sum: Int) {
        when {
            sum < 0 -> {}
            creditFunds < creditLimit -> {
                creditFunds += sum
                if (creditFunds > creditLimit) {
                    balance += (creditFunds - creditLimit)
                    creditFunds = creditLimit
                } else {}
            }
            else -> balance += sum
        }
    }

    override fun pay(sum: Int): Boolean {
        if (sum > balance + creditFunds) return false
        else {
            balance -= sum
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
        println("Личных средств на карте $balance, доступно кредитных средств $creditFunds")
    }
}