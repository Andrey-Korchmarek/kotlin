abstract class BankCard(money: Int) {
    protected var balance: Int

    init {
        balance = 0
        this.topUp(money)
    }

    abstract fun topUp(money: Int)
    abstract fun pay(money: Int): Boolean
    abstract fun balanceInfo()
    abstract fun fundsInfo()
}