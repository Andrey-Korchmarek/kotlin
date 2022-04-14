interface CurrencyConverter {
    val currencyCode: String
    fun convertToRub(sumRub: Int): String
        //String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}