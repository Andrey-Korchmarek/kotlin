class INRConverter : CurrencyConverter {
    override val currencyCode: String = "INR"
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}