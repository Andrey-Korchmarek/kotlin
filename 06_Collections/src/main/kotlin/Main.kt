/*
Что нужно сделать
Разработайте консольную программу, имитирующую работу телефонного справочника.
1. Введите число N с клавиатуры. Вводимые символы должны проверяться на соответствие условию N > 0.
В случае невыполнения условия программа должна указывать на ошибку ввода и предлагать ввести число до тех пор,
пока не будет введено корректное значение.
2. Введите следующие N телефонных номеров пользователей. Каждый номер должен представлять из себя строку.
3. Сохраните введённые номера в список. Используйте для этого MutableList.
Заносите в него значения с помощью цикла.
4. Вынесите шаги 2 и 3 в функцию, которая принимает число N и
возвращает список из N номеров телефонов, введённых с клавиатуры.
5. Выведите в консоль только номера телефонов, начинающиеся с приставки +7.
Для этого отфильтруйте список с помощью функции filter и распечатайте его.
6. Выведите в консоль количество уникальных введённых номеров.
Для этого преобразуйте список в множество c помощью функции toSet() и получите размер множества size.
7. Вычислите и распечатайте сумму длин всех номеров телефонов с помощью агрегирующей функции коллекции sumOf.
8. Создайте изменяемое представление — MutableMap.
Для каждого уникального номера из множества введите имя человека и заполните Map так,
чтобы в качестве ключа выступал номер телефона, а в качестве значения — введённое с консоли имя человека.
       Пример работы:
       Введите имя человека с номером телефона +79110123456: Андрей
       Введите имя человека с номером телефона +79229876543: Олег
       По окончании ввода Map должно содержать записи:
       (key=+79110123456, value:Андрей)
       (key=+79229876543, value:Олег)
9. Выведите содержимое Map в консоль в следующем виде:
Абонент: Андрей. Номер телефона: +79110123456
Абонент: Олег. Номер телефона: +79229876543
10. По желанию выведите содержимое Map, отсортированное по номерам телефона.
11. По желанию выведите содержимое Map, отсортированное по имени абонента.

Что оценивается
- Должны быть выполнены все обязательных задания.
- Если с заданиями 9 и 10 возникнут проблемы, попросите помощи у преподавателя или пропустите задание.
- Функции соответствуют принципам чёрного ящика, выполняют атомарные операции и независимы друг от друга.
- Функции возвращают неизменяемые коллекции.
- Названия переменных должны отражать суть данных, на которые они ссылаются.
- Переменные, которые не изменяются в программе, должны быть объявлены неизменяемыми.
- Различные выводы в консоль должны начинаться с новой строки.
*/


fun Int?.lessOrNull(value: Int): Boolean =
    when(this){
        null -> true
        in Int.MIN_VALUE until value -> true
        in value..Int.MAX_VALUE -> false
        else -> false
    }

fun Int?.moreOrNull(value: Int): Boolean =
    when(this){
        null -> true
        in Int.MIN_VALUE until value -> false
        in value..Int.MAX_VALUE -> true
        else -> false
    }

fun messageReadline(message: String, end: String = "\n"): String?{
    val result: String?

    print(message)
    result = readLine()
    print(end)
    return result
}

fun readMListOfString(n: Int): MutableList<String> {
    val result = emptyList<String>().toMutableList()

    println("Введите $n телефонных номеров")
    (0 until n).forEach {result.add(it, readLine()!!) }
    return result
}

fun main() {
    var n: Int?
    val phoneNumList: MutableList<String>
    val phoneNumSet: Set<String>
    val phoneNumMap: Map<String, String?>

    println("Введите натуральное число")
    n = readLine()?.toIntOrNull()
    while (n.lessOrNull(1)) {
        println("Ошибка: только натуральные числа! Введите ещё раз")
        n = readLine()?.toIntOrNull()
    }
    phoneNumList = readMListOfString(n!!)
    phoneNumList.forEach { println(it) }
    println("--------------------------------------------")
    phoneNumList.filter { it.startsWith("+7")}.forEach { println(it) }
    println("--------------------------------------------")
    phoneNumSet = phoneNumList.toSet()
    println(phoneNumSet.size)
    println(phoneNumList.sumOf { it.length })
    phoneNumMap = HashMap(phoneNumSet.associateWith {messageReadline("Введите имя человека с номером телефона $it:")})
    phoneNumMap.forEach { (number: String, name: String?) -> println("Абонент: $name. Номер телефона: $number") }
}
