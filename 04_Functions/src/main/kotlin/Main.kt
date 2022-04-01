/*
Я зашифровал некоторое сообщение. Алгоритм, который я использовал, выглядит так:

1. Разделить сообщение пополам.
2. Обработать первую половину сообщения следующим образом:
2.1. В исходном тексте заменить все символы о на символ 0 (ноль).
2.2. В получившемся тексте заменить каждый символ сообщения символом,
стоящим на 3 правее от исходного (сдвиг каждого символа вправо на 3).
2.3. В получившемся тексте заменить все символы u на цифру 4.
2.4. В получившемся тексте заменить все символы s на цифру 5.
2.5. В получившемся тексте заменить каждый символ сообщения символом,
стоящим на 1 левее от исходного (сдвиг каждого символа влево на 1).
3. Вторую половину сообщения обработать так:
3.1. Заменить пробелы на символ _
3.2. В получившемся тексте заменить каждый символ сообщения символом,
стоящим на 4 правее от исходного (сдвиг каждого символа вправо на 4).
3.3. Развернуть получившуюся строку.
4. Соединить обе зашифрованные половины.

В результате работы алгоритма я получил строку: F2p)v"y233{0->c}ttelciFc

Напишите программу, которая будет расшифровывать сообщение и выводить исходное сообщение в консоль.
Для расшифровки текста напишите функции, которые будут проходить алгоритм в обратном направлении:
например, заменить все символы 5 на символ s — обратное действие для пункта 2.4 моего алгоритма.
1. Создайте функцию для расшифровки первой половины сообщения. Используйте для этого алгоритм, обратный данному.
2. Создайте функцию для расшифровки второй половины сообщения. Используйте для этого алгоритм, обратный данному.
3. По желанию. Создайте функцию высшего порядка shift(), с помощью которой можно осуществлять сдвиг
всех символов в строке. Функция должна:
принимать на вход строку и функцию преобразования текущего символа (параметр функционального типа);
возвращать изменённую строку.
Используйте эту функцию в функциях 1 и 2.


Советы и рекомендации
Для замены всех символов строки символом правее/левее (сдвиг всех символов вправо/влево)
используйте функцию высшего порядка map, которая принимает лямбда-выражение по обработке
текущего символа в связке с вызовом функции joinToString(“”),
которая преобразует результат работы функции map в строку.
val shiftedString = sourceString.map {char -> char + 1}.joinToString(“”) ― заменяет все символы строки
на соседний символ, справа от текущего (сдвиг всех символов вправо на 1).
Воспользуйтесь документацией по функции map и reversed.

Что оценивается
Должны быть выполнены два обязательных задания.
Если с заданием 3 возникнут проблемы, попросите помощи у преподавателя или пропустите задание.
Названия переменных должны отражать суть данных, на которые они ссылаются.
Переменные, которые не изменяются в программе, должны быть объявлены неизменяемыми.
Различные выводы в консоль должны начинаться с новой строки.
*/

fun shift(str: String, lambda: (_: Char) -> Char): String{
    return str.map {lambda(it)}.joinToString("")
}

fun encrypt(sourse: String): String {
    val encriptedString: String
    var firstHalf: String
    var secondHalf: String
    val len: Int

    len = sourse.length
    firstHalf = sourse.substring(0, len / 2 + len % 2 - 1)
    firstHalf = firstHalf.replace('о', '0')
    firstHalf = shift(firstHalf, {char -> char + 3})
    firstHalf = firstHalf.replace('u', '4')
    firstHalf = firstHalf.replace('s', '5')
    firstHalf = shift(firstHalf, {char -> char - 1})

    secondHalf = sourse.substring(len / 2 + len % 2)
    secondHalf = secondHalf.replace(' ', '_')
    secondHalf = shift(secondHalf, {char -> char + 4})
    secondHalf = secondHalf.reversed()

    encriptedString = firstHalf + secondHalf
    return encriptedString
}

fun decrypt(sourse: String): String{
    val decriptedString: String
    var firstHalf: String
    var secondHalf: String
    val len: Int

    len = sourse.length
    firstHalf = sourse.substring(0, len / 2 + len % 2 - 1)
    firstHalf = shift(firstHalf, {char -> char + 1})
    firstHalf = firstHalf.replace('5','s')
    firstHalf = firstHalf.replace('4', 'u')
    firstHalf = shift(firstHalf, {char -> char - 3})
    firstHalf = firstHalf.replace('0', 'o')

    secondHalf = sourse.substring(len / 2 + len % 2)
    secondHalf = secondHalf.reversed()
    secondHalf = shift(secondHalf, {char -> char - 4})
    secondHalf = secondHalf.replace('_', ' ')

    decriptedString = firstHalf + secondHalf
    return decriptedString
}

fun main(args: Array<String>) {
    val flag : String? = if (args.size <= 1) null else args[1]
    val args0: String = if (args.size == 0) "F2p)v\"y233{0->c}ttelciFc" else args[0]
    println("${if (flag == "cipher") "Source" else "Encrypted"} string is $args0")
    println(if (flag == "cipher") "Encrypted string is ${encrypt(args0)}" else "Origin string is ${decrypt(args0)}")
}