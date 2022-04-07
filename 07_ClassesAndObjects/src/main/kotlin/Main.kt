import kotlin.random.Random

/*
Что нужно сделать.
Создайте собственный класс TV, который описывает множество телевизоров и
обладает всеми перечисленными характеристиками и действиями.
1. У класса следующие свойства:
- марка, модель, размер диагонали — эти свойства доступны для чтения,
есть возможность создавать телевизоры разных моделей и размеров;
- включён/выключен — свойство доступно для чтения и недоступно для записи;
- список каналов — внутреннее свойство телевизора, недоступно для чтения;
- максимальная громкость — внутреннее свойство, значение константное,
поэтому располагается в объекте-компаньоне этого класса.
2. Класс обладает следующими функциями:
- включение/выключение;
- увеличение громкости на заданную величину;
- уменьшение громкости на заданную величину;
- переключение канала на заданный (аналог нажатия кнопки с цифрой канала на пульте);
если телевизор выключен, то использование этой функции включает телевизор и переключает канал на заданный;
- переключение каналов в порядке возрастания и убывания
(аналог нажатия кнопок переключения каналов «Вверх» и «Вниз» на пульте);
если телевизор выключен, то использование этих функций включает телевизор на канале,
который был до выключения; переключение каналов непрерывно:
после последнего канала включается первый из списка;
- представление списка каналов в виде $порядковый_номер — $название_канала для отображения.
3. При создании объекта класса «Телевизор» проводится настройка каналов.
Список каналов заполняется случайными неповторяющимися каналами.
Для получения случайных каналов объявите собственный object Channels.
Он должен содержать список всех возможных каналов и функцию getRandomChannels,
которая будет возвращать список случайных каналов. Можете реализовать эту функцию самостоятельно.
Один из вариантов реализации:
- с помощью функции shuffled перемешайте список каналов;
- выберите оттуда необходимое для каждого телевизора количество.
4. Списки каналов у разных телевизоров различаются.
Величина списка каналов у телевизоров может быть разной.
5. Каналы представлены строками с названием.
По желанию создайте дополнительный класс Channel для описания канала.
6. Напишите программу, которая создаёт несколько экземпляров телевизоров.
- Для каждого экземпляра выведите информацию об этом телевизоре.
- Для каждого экземпляра вызовите все доступные функции и убедитесь, что они работают корректно.
Для этого в каждую
вызываемую функцию добавьте вывод в консоль информации о текущих значениях полей экземпляра.
Например, в функцию увеличения громкости добавьте вывод обновлённого значения текущей громкости.
- Используйте циклы для проверки функций работы с громкостью и функций последовательного переключения каналов.
- Все вызовы функций корректно обрабатываются, если телевизор выключен (если не сказано обратного).

Задания по желанию
1. Создайте свой класс, который описывает выбранный вами объект или явление.
- Определите, какой объект или явление будет описывать этот класс.
- Установите, какие характеристики и свойства есть у описываемого объекта.
- Определите, какие действия должны быть доступны для этого объекта.
2. Опишите в этом классе необходимые поля и реализуйте функции.
3. Создайте экземпляр этого класса и убедитесь, что всё функционирует корректно.
4. Перечислите, что описывает созданный вами класс и какие функции он выполняет.
Приложите текст через форму для сдачи
домашнего задания, чтобы проверяющий преподаватель смог оценить, насколько созданный вами класс
соответствует описанию.

Что оценивается
- Программа запускается, работает корректно и выводит всю необходимую информацию.
- Выполнены все обязательные пункты задания.
- Функции соответствуют принципам чёрного ящика, выполняют атомарные операции и независимы друг от друга.
- Функции возвращают неизменяемые коллекции.
- Названия переменных отражают суть данных, на которые они ссылаются.
- Переменные, которые не изменяются в программе, объявлены неизменяемыми.
- Внутренние члены класса — с модификатором private.
- Различные выводы в консоль начинаются с новой строки.
*/

fun doNothing() {}

fun doNothingOrElse(criterion: Boolean, alternative: () -> Unit) = run { if (criterion) doNothing() else alternative() }

fun main() {
    val tvSet: Set<List<String>>
    val testTvList: MutableList<TV>
    val testCard: MtGCard

    tvSet = setOf(
        listOf("Xiaomi", "Mi TV P1 43", "43"),
        listOf("Philips", "65PUS7406/60", "65"),
        listOf("LG", "50UP75006LF", "50"),
        listOf("Samsung", "UE32T4500AU", "32"),
        listOf("Sony", " KD-55A8", "55")
    )
    testTvList = emptyList<TV>().toMutableList()
    tvSet.forEach() { testTvList.add(TV(it[0], it[1], it[2].toUInt())) }
    doNothingOrElse(false) {
        println("Начинаем тест партии из ${testTvList.size} телевизоров!")
        testTvList.forEach() {
            println("Тестируем телевизор ${it.brand} модель ${it.model} диагональю ${it.diagonal}.")
            println("Сейчас состояние телевизора: ${if (it.on) "включён" else "выключен"}.")
            it.onOrOff()
            it.printInfo()
            it.displayChannelList()
            for (i in 1..(3..7).random()) {
                if (Random.nextBoolean()) it.onOrOff() else doNothing()
                it.switchChannel((0..50).random())
            }
            for (i in 1..(3..30).random()) {
                if (Random.nextBoolean()) it.onOrOff() else doNothing()
                it.plusChannel()
            }
            for (i in 1..(3..30).random()) {
                if (Random.nextBoolean()) it.onOrOff() else doNothing()
                it.minusChannel()
            }
            for (i in 1..(8..16).random()) {
                if (Random.nextBoolean()) it.onOrOff() else doNothing()
                it.plusVolume(Random.nextDouble(-1.0, 60.0))
            }
            for (i in 1..(8..16).random()) {
                if (Random.nextBoolean()) it.onOrOff() else doNothing()
                it.minusVolume(Random.nextDouble(-1.0, 60.0))
            }
            it.printInfo()
            println("Этот телевизор проверен!")
        }
        println("Тест окончен!")
    }
    testCard = MtGCard()
    doNothingOrElse(false) {
        testCard.readCard()
        testCard.turnCard()
        testCard.readCard()
    }
}