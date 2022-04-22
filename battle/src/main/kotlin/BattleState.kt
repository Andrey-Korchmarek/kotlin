sealed class BattleState{
    abstract val message: String

    class Progress(team1: Team, team2: Team) : BattleState() {
        override val message: String = """TEAM1 $team1
            |TEAM2 $team2
            |The battle continues!
        """.trimMargin()
    }
    object WinOf1 : BattleState() {
        override val message: String = "Team1 is WINNER!"
    }
    object WinOf2 : BattleState() {
        override val message: String = "Team2 is WINNER!"
    }
    object Raw : BattleState() {
        override val message: String = "RAW!"
    }
}
