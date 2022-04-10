abstract class BankCard(money: Int) {
    protected var balance: Int

    init {
        balance = 0
        this.topUp(money)
    }

    abstract fun topUp(sum: Int)
    abstract fun pay(sum: Int): Boolean
    abstract fun balanceInfo()
    abstract fun fundsInfo()
}