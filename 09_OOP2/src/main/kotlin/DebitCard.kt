open class DebitCard(money: Int) : BankCard(money) {

    override fun topUp(money: Int) {
        if (money > 0) { balance += money }
    }

    override fun pay(money: Int): Boolean =
        when {
            money < 0 -> false
            balance < money -> false
            else -> {
                balance -= money
                true
            }
        }

    override fun balanceInfo() = println("Баланс карты: $balance")

    override fun fundsInfo() = balanceInfo()
}