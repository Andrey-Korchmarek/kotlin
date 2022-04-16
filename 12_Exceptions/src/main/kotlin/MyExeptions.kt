class IncorrectPressure : Throwable(message = "Недопустимое давление!")

class TooLowPressure : Throwable(message = "Давление ниже нормального!")

class TooHighPressure : Throwable(message = "Давление выше нормального!")