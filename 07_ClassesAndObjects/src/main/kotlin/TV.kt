
class TV(val brand: String, val model: String, val diagonal: UInt) {
    var on: Boolean
        private set
    private val tvName: () -> String
    private val channelList: List<String>
    private var currentChannel: String
    private var currentVolume: Double

    init {
        tvName = {"$brand $model диагональю $diagonal\""}
        on = false
        channelList = Channels.getRandomChannels()
        currentChannel = channelList.first()
        currentVolume = 1.0
        println("Объект телевизор ${tvName()} создан.")
    }

    fun printInfo() {
        print("Это телевизор $brand, модель $model диагональю $diagonal\". ")
        if (!on) println("Он выключен.")
        else println("На нём идёт канал $currentChannel громкостью $currentVolume дБ.")
    }
    fun onOrOff() {
        on = on.not()
        println("Телевизор ${tvName()} ${ if (on) "включён" else "выключен" }.")
    }

    fun switchChannel(num: Int) {
        on = true
        currentChannel = channelList.getOrElse(num) { this.currentChannel }
        println("На телевизоре ${tvName()} включен канал $currentChannel.")
    }

    fun plusChannel() {
        if (on) {
            val channelNumber = channelList.indexOf(currentChannel)
            currentChannel = channelList.getOrElse(channelNumber + 1) { channelList[0] }
        }
        else on = true
        println("На телевизоре ${tvName()} включен канал $currentChannel.")
    }

    fun minusChannel() {
        if (on) {
            val channelNumber = channelList.indexOf(currentChannel)
            currentChannel = channelList.getOrElse(channelNumber - 1) {channelList.last()}
        }
        else on = true
        println("На телевизоре ${tvName()} включен канал $currentChannel.")
    }

    fun displayChannelList() {
        if (on) {
            println("Список каналов телевизора ${tvName()}:")
            channelList.forEachIndexed { index, value -> println("Канал номер ${index + 1} — $value") }
        }
        else { /* do nothing */ }
    }

    fun plusVolume(step: Double = 1.0) {
        if (on) {
            when {
                step < 0.0 -> { /* do nothing */ }
                currentVolume + step < 0.0 -> currentVolume = 0.0
                currentVolume + step > maxVolume -> currentVolume = maxVolume
                else -> currentVolume += step
            }
            println("Громкость телевизора ${tvName()} увеличена до $currentVolume дБ.")
        }
    }

    fun minusVolume(step: Double = 1.0) {
        if (on) {
            when {
                step < 0.0 -> { /* do nothing */ }
                currentVolume - step < 0.0 -> currentVolume = 0.0
                currentVolume - step > maxVolume -> currentVolume = maxVolume
                else -> currentVolume -= step
            }
            println("Громкость телевизора ${tvName()} уменьшена до $currentVolume дБ.")
        }
    }

    companion object {
        const val maxVolume: Double = 70.0
    }
}