package CurrencyExchange;

public class ExchangeService {

    public static Float exchanger(ExchangeDTO exchangeDTO) {
        String exchangeRateCodes = exchangeDTO.getFirstCurrencyCode() + exchangeDTO.getSecondCurrencyCode();
        String invertedExchangeRateCodes = exchangeDTO.getSecondCurrencyCode() + exchangeDTO.getFirstCurrencyCode();

        if (UtilRates.exchangeRates.containsKey(exchangeRateCodes.toUpperCase())) {
            Float rate = UtilRates.exchangeRates.get(exchangeRateCodes.toUpperCase());
            return rate * exchangeDTO.getAmountOfMoney();

        } else if (UtilRates.exchangeRates.containsKey(invertedExchangeRateCodes.toUpperCase())) {
            Float rate = 1 / UtilRates.exchangeRates.get(invertedExchangeRateCodes.toUpperCase());
            return rate * exchangeDTO.getAmountOfMoney();

        } else {
            return null;
        }
    }
}
