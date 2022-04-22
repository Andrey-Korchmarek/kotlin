import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

const val MAX_OF_LOTTO_CARDS = 45795673964460816UL

fun main(args: Array<String>) {
    var numberOfPlayers: ULong = 0UL
    var countOfCard: ULong = 0UL

    try {
        numberOfPlayers = args[0].toULong()
        countOfCard = args[1].toULong()
        if (numberOfPlayers < 2UL || countOfCard < 1UL) throw IllegalArgumentException()
        if (numberOfPlayers * countOfCard > MAX_OF_LOTTO_CARDS) throw IllegalStateException()
    } catch (e: NumberFormatException) {
        println("Программа принимает два положительных числа!")
        return
    }catch (e: IllegalArgumentException) {
        println("Для игры нужно минимум 2 человека и у каждого должна быть хотя бы 1 карточка!")
        return
    } catch (e: IllegalStateException) {
        println("У нас нет столько карточек!")
        return
    }catch (e: ArrayIndexOutOfBoundsException){
        loop@while (true) {
            while (numberOfPlayers < 2UL) {
                print("Введите число игроков - ")
                try {
                    numberOfPlayers = (readLine() ?: "0").toULong()
                } catch (e: NumberFormatException) {
                    println("Вы ошиблись в числе людей для игры!")
                }
            }
            while (countOfCard < 1UL) {
                print("Введите количество карточек у каждого игрока - ")
                try {
                    countOfCard = (readLine() ?: "0").toULong()
                } catch (e: NumberFormatException) {
                    println("Вы ошиблись в количестве карточек для игры!")
                }
            }
            if (numberOfPlayers * countOfCard < MAX_OF_LOTTO_CARDS) break@loop
            else println("У нас нет столько карточек!")
            numberOfPlayers = 0UL
            countOfCard = 0UL
        }
    } finally {
        CardsPack.generatePack(numberOfPlayers * countOfCard)
    }
    val players = mutableListOf<Player>()
    (1UL..numberOfPlayers).forEach {
        print("Введите имя игрока $it - ")
        players.add(Player(readLine(), countOfCard))
    }
    players.forEach { println(it) }
    runBlocking {
        Moderator.generateBarrels
            .onEach { println("Moderator took out of bag number $it!") }
            .launchIn(this)
        val jobs = mutableListOf<Job>()
        players.forEach {player ->
            jobs.add(
                launch {
                    Moderator
                        .generateBarrels
                        .collect { barrel ->
                            if (Moderator.isGameOver.value) cancel()
                            player.cards.forEach {
                                it.searchBarrel(barrel)
                            }
                            Moderator.isGameOver.value = player.cards.any { it.isWinner() }
                        }
                }
            )
        }
        jobs.forEach { it.join() }
    }
    //players.forEach { if (it.cards.any { it.isWinner() }) println("Победитель: ${it.name}") }
    println("Победитель: " + (players.find { it.cards.any { it.isWinner() } } ?: "никто не выиграл ^_^"))
    println("Карты всех игроков:")
    players.forEach { println(it) }
    println("Конец игры!")
}
