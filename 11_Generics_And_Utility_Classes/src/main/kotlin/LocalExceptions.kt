sealed class LocalExceptions : Throwable()

class NoAmmoException : LocalExceptions() {
    override val message: String = "В магазине недостаточно патронов для выстрела"
}

class EmptyStackException : LocalExceptions() {
    override val message: String = "Попытка взять элемент из пустого стека"
}