import kotlin.random.Random

class Team(size: Int) {
    val teamList = mutableListOf<AbstractWarrior>(Captain())
    val isHaveCommander: ()-> Boolean = { teamList.any { it is Captain } }

    init {
        if (size > 1) repeat((2..size).count()) {
            when (Random.nextInt(0, 100)) {
                0 -> teamList.add(Joker())
                in 1..5 -> teamList.add(Medic())
                in 6..15 -> teamList.add(Sniper())
                in 16..35 -> teamList.add(Terminator())
                in 36..60 -> teamList.add(Rowdy())
                else -> teamList.add(Fighter())
            }
        }
    }

    override fun toString(): String = teamList.toString()
}