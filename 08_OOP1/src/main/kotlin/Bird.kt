class Bird(name: String, maxAge: Int, energy: Int, weight: Int) :
    Animal(name, maxAge, energy, weight) {
    override fun move() {
        moveMessage = "летит"
        super.move()
    }

    override fun bear(): Bird {
        bornMessage = "а птица"
        val newAnimal = super.bear()
        return Bird(newAnimal.name, newAnimal.maxAge, newAnimal.energy, newAnimal.weight)
    }
}