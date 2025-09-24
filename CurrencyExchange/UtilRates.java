package CurrencyExchange;

import java.util.HashMap;

public class UtilRates {
    private static final Currency USD = new Currency("USD", "US Dollar", "$");
    private static final Currency EUR = new Currency("EUR", "Euro", "$");
    private static final Currency JPY = new Currency("JPY", "Japanese Yen", "$");
    private static final Currency RUB = new Currency("RUB", "Russian Ruble", "$");

    public static HashMap<String, Float> exchangeRates = new HashMap<>();

    public static void ratesInitializer() {
        exchangeRates.put("USDEUR", 0.85F);
        exchangeRates.put("USDJPY", 148.64F);
        exchangeRates.put("EURJPY", 174.55F);
        exchangeRates.put("JPYRUB", 0.56F);
        exchangeRates.put("USDRUB", 83.88F);
        exchangeRates.put("EURRUB", 98.44F);
    }


    public static Currency[] currencies = {USD, EUR, JPY, RUB};
}
