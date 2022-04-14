class JPYConverter : CurrencyConverter {
    override val currencyCode: String = "JPY"
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}