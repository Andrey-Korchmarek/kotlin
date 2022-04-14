import kotlin.random.Random

object Converters {
    private val converters = listOf<CurrencyConverter>(
        RUBConverter(),
        USDConverter(),
        EURConverter(),
        GBPConverter(),
        CNYConverter(),
        INRConverter(),
        JPYConverter(),
        KRWConverter(),
        UAHConverter(),
        BYNConverter(),
        KZTConverter(),
        CHFConverter(),
        OPBConverter(),
        NONConverter(),
    )
    fun get(currencyCode: String): CurrencyConverter = converters.find { it.currencyCode == currencyCode }?:
    object : CurrencyConverter {
        override val currencyCode: String = currencyCode
        override fun convertToRub(sumRub: Int) =
            String.format("%.2f", Random.nextDouble(0.01, 120.0).times(sumRub))
    }
}