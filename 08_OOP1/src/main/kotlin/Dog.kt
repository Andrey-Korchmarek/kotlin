class Dog(name: String, maxAge: Int, energy: Int, weight: Int) :
    Animal(name, maxAge, energy, weight) {
    override fun move() {
        moveMessage = "бежит"
        super.move()
    }

    override fun bear(): Dog {
        bornMessage = "а собака"
        val newAnimal = super.bear()
        return Dog(newAnimal.name, newAnimal.maxAge, newAnimal.energy, newAnimal.weight)
    }
}