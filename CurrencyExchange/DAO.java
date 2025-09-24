package CurrencyExchange;

public class DAO {
    public static String currencyFullNameByCodeGetter(String currencyCode) {
        for (int i = 0; i < UtilRates.currencies.length; i++) {
            if (UtilRates.currencies[i].getCurrencyCode().equalsIgnoreCase(currencyCode)) {
                return UtilRates.currencies[i].getCurrencyFullName();
            }
        }
        return null;
    }

    public static String currencySignByCodeGetter(String currencyCode) {
        for (int i = 0; i < UtilRates.currencies.length; i++) {
            if (UtilRates.currencies[i].getCurrencyCode().equalsIgnoreCase(currencyCode)) {
                return UtilRates.currencies[i].getCurrencySymbol();
            }
        }
        return null;
    }

    public static boolean isCurrenciesCodeInTheMap(String currencyCode) {
        for (int i = 0; i < UtilRates.currencies.length; i++) {
            if (UtilRates.currencies[i].getCurrencyCode().equalsIgnoreCase(currencyCode)) {
                return true;
            }
        }
        return false;
    }
}
