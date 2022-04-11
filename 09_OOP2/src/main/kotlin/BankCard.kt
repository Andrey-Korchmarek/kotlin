abstract class BankCard(money: Int) {
    protected var balance: Int
    protected open val infoMessage: () -> String

    init {
        balance = 0
        this.topUp(money)
        this.infoMessage = { "Средств на карте $balance" }
    }

    abstract fun topUp(sum: Int)
    abstract fun pay(sum: Int): Boolean
    fun balanceInfo() = println("Баланс карты - $balance")
    fun fundsInfo() = println(this.infoMessage() + ".")
}