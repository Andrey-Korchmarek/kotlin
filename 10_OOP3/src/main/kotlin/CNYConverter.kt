class CNYConverter : CurrencyConverter {
    override val currencyCode: String = "CNY"
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}