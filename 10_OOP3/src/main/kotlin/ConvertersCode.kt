enum class ConvertersCode : CurrencyConverter {
    Russia { override val currencyCode = "RUB" },
    USA { override val currencyCode = "USD" },
    Europe { override val currencyCode = "EUR" },
    GreatBritain { override val currencyCode = "GBP" },
    China { override val currencyCode = "CNY" },
    India { override val currencyCode = "INR" },
    Japan { override val currencyCode = "JPY" },
    Korea { override val currencyCode = "KRW" },
    Ukraine { override val currencyCode = "UAH" },
    Belarus { override val currencyCode = "BYN" },
    Kazakhstan { override val currencyCode = "KZT" },
    Switzerland { override val currencyCode = "CHF" },
    OnePiece { override val currencyCode = "OPB" },
    Neverland { override val currencyCode = "NON" };

}