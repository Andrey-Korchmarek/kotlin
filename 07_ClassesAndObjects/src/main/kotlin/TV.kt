class TV(val brand: String, val model: String, val diagonal: UByte) {
    var on: Boolean = false
        private set
    private val channelArray: List<String> = emptyList()

    fun print() {
        println("$diagonal\" $brand $model, черный")
    }
    fun onOrOff() {
        this.on = this.on.not()
    }

    companion object {
        const val maxVolume: Float = 20.0F
    }
}