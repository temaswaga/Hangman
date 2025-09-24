package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchangeUI {

    public static void enabledCurrenciesToExchangePrinter(){
        System.out.print("Enable to exchange currencies: ");
        for (int i = 0; i < UtilRates.currencies.length; i++) {
            System.out.print(UtilRates.currencies[i].getCurrencyCode());

            if (i != UtilRates.currencies.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    public static void currencyExchanger() {
        Scanner sc = new Scanner(System.in);
        String firstCurrencyCode;
        String secondCurrencyCode;
        float amountOfExchangingMoney;

        System.out.print("Please, write a code of the currency you want to exchange: ");
        do{
            firstCurrencyCode = sc.nextLine();
            if (firstCurrencyCode.length() != 3) {

                System.out.print("\nIncorrect format, please write a 3 digit currency code from enable currencies list (like 'USD' or 'EUR'): ");
            } else if (!DAO.isCurrenciesCodeInTheMap(firstCurrencyCode)) {
                System.out.print("\nPlease, enter a valid currency code from enable currencies list: ");
            }
        } while (firstCurrencyCode.length() != 3 || !DAO.isCurrenciesCodeInTheMap(firstCurrencyCode));


        System.out.print("Now please, write a code of the currency you want to be exchanged into: ");
        do{
            secondCurrencyCode = sc.nextLine();
            if (secondCurrencyCode.length() != 3) {
                System.out.print("\nIncorrect format, please write a 3 digit currency code from enable currencies list (like 'USD' or 'EUR'): ");
            } else if (!DAO.isCurrenciesCodeInTheMap(secondCurrencyCode)) {
                System.out.print("\nPlease, enter a valid currency code from enable currencies list: ");
            } else if (secondCurrencyCode.equalsIgnoreCase(firstCurrencyCode)) {
                System.out.print("Please, enter other then first currency code from enable currencies list: ");
            }
        } while (secondCurrencyCode.length() != 3 || !DAO.isCurrenciesCodeInTheMap(secondCurrencyCode) || secondCurrencyCode.equalsIgnoreCase(firstCurrencyCode));

        System.out.print("How much of " + DAO.currencyFullNameByCodeGetter(firstCurrencyCode) + " do you want to exchange: ");
        amountOfExchangingMoney = sc.nextFloat();

        String result = String.format("%.2f", ExchangeService.exchanger(new ExchangeDTO(firstCurrencyCode, secondCurrencyCode, amountOfExchangingMoney)));
        System.out.print("Result of your exchange is: " + result + DAO.currencySignByCodeGetter(secondCurrencyCode));


    }
}
