class USDConverter : CurrencyConverter {
    override val currencyCode: String = "USD"
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}