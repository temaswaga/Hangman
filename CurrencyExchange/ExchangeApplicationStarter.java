package CurrencyExchange;

public class ExchangeApplicationStarter {
    public static void main(String[] args) {
        UtilRates.ratesInitializer();
        CurrencyExchangeUI.enabledCurrenciesToExchangePrinter();
        CurrencyExchangeUI.currencyExchanger();
    }
}
