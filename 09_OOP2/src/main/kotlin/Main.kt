fun main() {
    val fanta = emptyList<DebitCashbackMoneyCard>().toMutableList()
    val pepsi = emptyList<DebitCashbackConstCard>().toMutableList()
    val lemon = emptyList<DebitFreeCard>().toMutableList()
    val cola = emptyList<CreditCashbackBonusCard>().toMutableList()
    val soda = emptyList<CreditCashbackDiscountCard>().toMutableList()
    val mate = emptyList<CreditIncreaseDepositsCard>().toMutableList()
    val cards: List<MutableList<out BankCard>> = listOf(fanta, pepsi, lemon, cola, soda, mate)

    (-1..7).forEach() {
        val money = it * (10..250).random()
        val limit = it * (1000..5000).random()
        val cashback = it * (1..10).random()
        fanta.add(DebitCashbackMoneyCard(money,cashback))
        pepsi.add(DebitCashbackConstCard(money,cashback))
        lemon.add(DebitFreeCard(money,it * (1000..100000).random()))
        cola.add(CreditCashbackBonusCard(money,limit,cashback))
        soda.add(CreditCashbackDiscountCard(money,limit,cashback))
        mate.add(CreditIncreaseDepositsCard(money,limit, it * (5..15).random()))
    }
    cards.forEach {
        println(it[0]::class.simpleName)
        it.forEach { with(it) {
            fundsInfo()
            println("Попытка покупки -1: ${if (pay(-1)) "успешно" else "провал"}.")
            println("Попытка покупки 5000: ${if (pay(5000)) "успешно" else "провал"}.")
            balanceInfo()
            println("Попытка покупки 250: ${if (pay(250)) "успешно" else "провал"}.")
            balanceInfo()
            println("Попытка покупки 10: ${if (pay(10)) "успешно" else "провал"}.")
            balanceInfo()
            println("Попытка покупки 0: ${if (pay(0)) "успешно" else "провал"}.")
            fundsInfo()
            topUp(-1)
            println("Пополнение на -1.")
            balanceInfo()
            topUp(777777)
            println("Пополнение на 777777.")
            if (it is CreditCashbackBonusCard)
                println("Покупка за 1 балл: ${if (it.payWithBonuses(1)) "успешно" else "провал"}.")
            fundsInfo()
        } }
    }
    println("Конец программы.")
}
