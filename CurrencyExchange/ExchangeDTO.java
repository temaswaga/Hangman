package CurrencyExchange;

public class ExchangeDTO {
    private String firstCurrencyCode;
    private String secondCurrencyCode;
    private Float amountOfMoney;

    public ExchangeDTO(String firstCurrencyCode, String secondCurrencyCode, Float amountOfMoney) {
        this.firstCurrencyCode = firstCurrencyCode;
        this.secondCurrencyCode = secondCurrencyCode;
        this.amountOfMoney = amountOfMoney;
    }

    public String getFirstCurrencyCode() {
        return firstCurrencyCode;
    }

    public String getSecondCurrencyCode() {
        return secondCurrencyCode;
    }

    public Float getAmountOfMoney() {
        return amountOfMoney;
    }
}
