package CurrencyExchange;

public class Currency {
    private String currencyCode;
    private String currencyFullName;
    private String currencySymbol;

    public Currency(String currencyCode, String currencyFullName, String currencySymbol) {
        this.currencyCode = currencyCode;
        this.currencyFullName = currencyFullName;
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyFullName() {
        return currencyFullName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
}
