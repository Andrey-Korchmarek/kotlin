import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

object Moderator {
    private val barrelsBag: Set<Byte> = (1..90).map { it.toByte() }.toSet()
    val isGameOver = MutableStateFlow(false)
    val generateBarrels =
        barrelsBag
            .shuffled()
            .asFlow()
            .onStart { delay(500) }
            .onEach { delay(300) }
            .takeWhile { isGameOver.value == false }
}