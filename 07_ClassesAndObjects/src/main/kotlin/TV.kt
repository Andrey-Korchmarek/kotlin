import com.sun.jdi.VoidValue

class TV(val brand: String, val model: String, val diagonal: UInt) {
    var on: Boolean
        private set
    private val tvName: () -> String
    private val channelList: List<String>
    private var currentChannel: String
    private var currentVolume: Double

    init {
        tvName = {"${this.brand} ${this.model} диагональю ${this.diagonal}\""}
        on = false
        channelList = Channels.getRandomChannels()
        currentChannel = channelList.first()
        currentVolume = 1.0
        println("Объект телевизор ${this.tvName()} создан.")
    }

    fun printInfo() {
        print("Это телевизор ${this.brand}, модель ${this.model} диагональю ${this.diagonal}\". ")
        if (!this.on) println("Он выключен.")
        else println("На нём идёт канал ${this.currentChannel} громкостью ${this.currentVolume} дБ.")
    }
    fun onOrOff() {
        this.on = this.on.not()
        println("Телевизор ${this.tvName()} ${ if (this.on) "включён" else "выключен" }.")
    }

    fun switchChannel(num: Int) {
        this.on = true
        this.currentChannel = channelList.getOrElse(num) { this.currentChannel }
        println("На телевизоре ${this.tvName()} включен канал ${this.currentChannel}.")
    }

    fun plusChannel() {
        if (this.on) {
            val channelNumber = channelList.indexOf(this.currentChannel)
            this.currentChannel = channelList.getOrElse(channelNumber + 1) { channelList[0] }
        }
        else this.on = true
        println("На телевизоре ${this.tvName()} включен канал ${this.currentChannel}.")
    }

    fun minusChannel() {
        if (this.on) {
            val channelNumber = channelList.indexOf(this.currentChannel)
            this.currentChannel = channelList.getOrElse(channelNumber - 1) {channelList.last()}
        }
        else this.on = true
        println("На телевизоре ${this.tvName()} включен канал ${this.currentChannel}.")
    }

    fun displayChannelList() {
        if (this.on) {
            println("Список каналов телевизора ${this.tvName()}:")
            channelList.forEachIndexed { index, value -> println("Канал номер ${index + 1} — $value") }
        }
        else { /* do nothing */ }
    }

    fun plusVolume(step: Double = 1.0) {
        if (this.on) {
            when {
                step < 0.0 -> { /* do nothing */ }
                this.currentVolume + step < 0.0 -> this.currentVolume = 0.0
                this.currentVolume + step > maxVolume -> this.currentVolume = maxVolume
                else -> this.currentVolume += step
            }
            println("Громкость телевизора ${this.tvName()} увеличена до $currentVolume дБ.")
        }
    }


    fun minusVolume(step: Double = 1.0) {
        if (this.on) {
            when {
                step < 0.0 -> { /* do nothing */ }
                this.currentVolume - step < 0.0 -> this.currentVolume = 0.0
                this.currentVolume - step > maxVolume -> this.currentVolume = maxVolume
                else -> this.currentVolume -= step
            }
            println("Громкость телевизора ${this.tvName()} уменьшена до $currentVolume дБ.")
        }
    }

    companion object {
        const val maxVolume: Double = 70.0
    }
}