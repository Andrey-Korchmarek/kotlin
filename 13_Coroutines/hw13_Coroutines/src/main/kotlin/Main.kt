import kotlinx.coroutines.*
import java.math.BigInteger

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        var sum: BigInteger
        var temp1: BigInteger = 0.toBigInteger()
        var temp2: BigInteger = 1.toBigInteger()
        var i: Int = -1
        do {
            yield()
            when (i) {
                -1 -> sum = i.toBigInteger()
                0 -> sum = temp1
                1 -> sum = temp2
                else -> {
                    sum = temp1 + temp2
                    temp1 = temp2
                    temp2 = sum
                }
            }
            i += 1
        } while (i <= n)
        return sum
    }
}

suspend fun test(n: Int, time: Long = 2000): String {
    var result: String
    try {
        withTimeout(time) { result = "Число Фибоначи $n: ${Fibonacci.take(n)}" }
    } catch (e: TimeoutCancellationException) {
        result = "Задача выполнялась слишком долго."
    }
    //println(result)
    return result

}

fun main() = runBlocking<Unit>{
    val numbers = listOf(500000, 1000, 1500)
    val text = mutableListOf<String>()
    val jobs = mutableListOf<Job>()
    numbers.forEach {
        text.add("")
        jobs.add(launch { text[numbers.indexOf(it)] = test(it) })
    }
    val job0 = launch {
        while (jobs.any { it.isActive }) {
            yield()
            delay(10)
            print(".")
        }
    }
    jobs.forEach {it.join()}
    job0.join()
    println()
    text.forEach { println(it) }
}