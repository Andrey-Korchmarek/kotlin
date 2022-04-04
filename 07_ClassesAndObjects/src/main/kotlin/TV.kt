import com.sun.jdi.VoidValue

class TV(val brand: String, val model: String, val diagonal: UByte) {
    var on: Boolean = false
        private set
    private var currentVolume: Double = 1.0
    private val channelList: List<String> = listOf("2x2")
    private var currentChannel: String = channelList[0]

    fun print() {
        println("$diagonal\" $brand $model, черный")
    }
    fun onOrOff() {
        this.on = this.on.not()
    }

    fun plusVolume(step: Double = 1.0) =
        when {
            step < 0.0 -> { /* do nothing */ }
            this.currentVolume + step < 0.0 -> this.currentVolume = 0.0
            this.currentVolume + step > maxVolume -> this.currentVolume = maxVolume
            else -> this.currentVolume += step
        }

    fun minusVolume(step: Double = 1.0) =
        when {
            step < 0.0 -> { /* do nothing */ }
            this.currentVolume - step < 0.0 -> this.currentVolume = 0.0
            this.currentVolume - step > maxVolume -> this.currentVolume = maxVolume
            else -> this.currentVolume -= step
        }

    fun switchChannel(num: Int) {
        this.on = true
        val tempChannel: String? = channelList.getOrNull(num)
        if (tempChannel != null) { this.currentChannel = tempChannel }
        println(this.currentChannel)
    }

    fun plusChannel() {
        if (this.on) {
            val channelNumber = channelList.indexOf(this.currentChannel)
            //this.currentChannel = channelList.getOrElse(channelNumber + 1, 0)
        }
        else this.onOrOff()
        println(this.currentChannel)
    }

    fun minusChannel() {
        if (this.on) {
            val channelNumber = channelList.indexOf(this.currentChannel)
            //this.currentChannel = channelList.getOrElse(channelNumber - 1, channelList.lastIndex)
        }
        else this.onOrOff()
        println(this.currentChannel)
    }

    fun displayChannelList() {
        if (this.on) { channelList.forEachIndexed { index, value -> println("${index + 1} — $value") } }
    }

    companion object {
        const val maxVolume: Double = 20.0
    }
}