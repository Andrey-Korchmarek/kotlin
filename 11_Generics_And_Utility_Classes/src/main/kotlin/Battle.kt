import java.lang.Integer.min

class Battle(count: Int) {
    private val com1: Team = Team(count)
    private val com2: Team = Team(count)
    var battleIsOver: Boolean = false
    private val history: MutableList<BattleState> = mutableListOf(this.getStateOfBattle())

    init {
        println(history.last().message)
    }

    private fun getStateOfBattle(): BattleState =
        when (com1.isHaveCommander() to com2.isHaveCommander()) {
            false to false -> BattleState.Raw
            true to false -> BattleState.WinOf1
            false to true -> BattleState.WinOf2
            else -> BattleState.Progress(com1, com2)
        }
    fun battleIteration() {
        val one = com1.teamList
        val two = com2.teamList
        val a = one.size
        val b = two.size
        for (i in 0 until min(a, b)) {
            one[i].attack(two[i])
            two[i].attack(one[i])
            when {
                one[i].isKilled() && two[i].isKilled() ->
                    println("1team№$i ${one[i]} and 2team№$i ${two[i]} killed each other.")
                one[i].isKilled() -> println("2team№$i ${two[i]} kill 1team№$i ${one[i]}.")
                two[i].isKilled() -> println("1team№$i ${one[i]} kill 2team№$i ${two[i]}.")
                else -> println("1team№$i ${one[i]} and 2team№$i ${two[i]} survived.")
            }
        }
        when {
            a < b -> (a until  b).forEach {
                val enemy = one.random()
                two[it].attack(enemy)
                if (enemy.isKilled()) println("2team№$it kill random from 1team.")
                else println("2team№$it attack random from 1team.")
            }
            b < a -> (b until  a).forEach {
                val enemy = two.random()
                one[it].attack(enemy)
                if (enemy.isKilled()) println("1team№$it kill random from 2team.")
                else println("1team№$it attack random from 2team.")
            }
            else -> doNothing()
        }
        println("Warriors do their special actions.")
        one.forEach { it.specialAction(one.random()) }
        two.forEach { it.specialAction(one.random()) }
        one.removeIf { it.isKilled() }
        two.removeIf { it.isKilled() }
        com1.teamList.shuffle()
        com2.teamList.shuffle()
        history.add(getStateOfBattle())
        if (!com1.isHaveCommander() || !com2.isHaveCommander()) {
            battleIsOver = true
            println("TEAM1 $com1")
            println("TEAM2 $com2")
            println(history.last().message)
        }
        else doNothing()
    }
}