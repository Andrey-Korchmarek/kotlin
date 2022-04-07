class NatureReserve {
    var elements: MutableList<Animal>
        private set
    private val namesSet: Set<String>

    init {
        namesSet = with(
            """Боря Кеша Васька Рыжик Снежок Тёма Петя Муза Аслан Язь Юшка Щекотка Шива Ханна Хулиган Бандит Нянько 
            Утя Ура Тимка Тигра Тундра Саян Симба Рая Ряба Пикачу Мяут Мэджикарп Мью Ода Мао Иосиф ^_^ XD Маруся 
            Март Апрель Май Июнь Июль Август Сентябрь Октябрь Ноябрь Декабрь Январь Февраль Юпитер Зевс Геракл Аид 
            Тор Индра Агни Кубера Лиз Юта Маруна Рен Рана Гандахарва Ананта Вишну Кали Время Луффи Римуру Наофуми 
            Баам Сайтама Кумоко Исида Зоря Z Жучка Жиза Европа Ева Догма Дымка Черныш Пушина Птичка Рыбка Годзилла 
            Гея Бетховен Лесси Хатико Брут Аша Акела"""
        ) {
            replace('\t', ' ')
            replace('\n', ' ')
            replace("\\s+".toRegex(), " ")
        }
            .split(' ')
            .toSet()
    }

    init {
        val maxAgeSpread = (1..7)
        val energySpread = (1..5)
        val weightSpread = (1..3)
        elements = emptyList<Animal>().toMutableList()
        (1..5).forEach() { elements.add(Bird(namesSet.random(), maxAgeSpread.random(),
            energySpread.random(), weightSpread.random())) }
        (1..3).forEach() { elements.add(Fish(namesSet.random(), maxAgeSpread.random(),
            energySpread.random(), weightSpread.random())) }
        (1..2).forEach() { elements.add(Dog(namesSet.random(), maxAgeSpread.random(),
            energySpread.random(), weightSpread.random())) }
        (1..7).forEach() { elements.add(Animal(namesSet.random(), maxAgeSpread.random(),
            energySpread.random(), weightSpread.random())) }
    }
    fun oneTime() {
        val newborn: MutableList<Animal> = emptyList<Animal>().toMutableList()
        elements.forEach { run( setOf(
            { it.sleep() },
            { it.eat() },
            { it.move() },
            { newborn.add(it.bear()) },
                ).random() )
        }
        elements.addAll(newborn)
        elements.removeIf { it.isTooOld() }
    }
}