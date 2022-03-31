fun main() {
    val firstName: String
    val lastName: String
    var height: Double
    val weight: Float
    val isChild: () -> Boolean
    val info: () -> String

    firstName = "Андрей"
    lastName = "Корчмарек"
    height = 1.78
    weight = 150.4f
    isChild = {(height < 1.5) || (weight < 40)}
    info = {"""Меня зовут $firstName $lastName. 
    Я ${if (isChild()) "ребёнок" else "взрослый"} ростом $height метров и весом $weight кг.""".trimMargin()}
    println(info())
    height -= 0.29
    println(info())
}