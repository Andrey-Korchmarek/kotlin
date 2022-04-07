class Fish(name: String, maxAge: Int, energy: Int, weight: Int) :
    Animal(name, maxAge, energy, weight) {
    override fun move() {
        moveMessage = "плывёт"
        super.move()
    }

    override fun bear(): Fish {
        bornMessage = "а рыба"
        val newAnimal = super.bear()
        return Fish(newAnimal.name, newAnimal.maxAge, newAnimal.energy, newAnimal.weight)
    }
}