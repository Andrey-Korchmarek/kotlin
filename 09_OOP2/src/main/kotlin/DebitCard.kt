open class DebitCard(money: Int) : BankCard(money) {

    override fun topUp(sum: Int) {
        if (sum > 0) { balance += sum }
    }

    override fun pay(sum: Int): Boolean =
        when {
            sum < 0 -> false
            balance < sum -> false
            else -> {
                balance -= sum
                true
            }
        }
}