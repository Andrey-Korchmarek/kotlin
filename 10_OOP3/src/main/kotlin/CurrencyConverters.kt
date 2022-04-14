class RUBConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Russia.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class USDConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.USA.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class EURConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Europe.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class GBPConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.GreatBritain.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class CNYConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.China.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class INRConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.India.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class JPYConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Japan.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class KRWConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Korea.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class UAHConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Ukraine.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class BYNConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Belarus.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class KZTConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Kazakhstan.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class CHFConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Switzerland.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class OPBConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.OnePiece.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}

class NONConverter : CurrencyConverter {
    override val currencyCode: String = ConvertersCode.Neverland.code
    override fun convertToRub(sumRub: Int): String =
        String.format("%.2f", CurrencyRate.valueOf(currencyCode).currentRate.times(sumRub))
}