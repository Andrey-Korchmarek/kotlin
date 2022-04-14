class EURConverter : CurrencyConverter {
    override val currencyCode: String = "EUR"
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}