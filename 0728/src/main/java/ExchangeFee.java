import java.util.Scanner;

public class ExchangeFee {

  public Money getMoney() {
    return money;
  }
  public double getMoneyValue(){
    return money.getValue();
  }
  public void setMoneyValue(double value){
    ExchangeFee.money.setValue(value);
  }

  static Money money;

  public ExchangeFee(Money money) {
    ExchangeFee.money = money;
  }

  public void checkExchange() {
    Scanner scanner = new Scanner(System.in);
    String changingCurrency;
    System.out.println("환전하고 싶은 통화를 입력하세요.");
    changingCurrency = scanner.next();
    exchange(money,changingCurrency);
    printExchanging();
  }


  public static Money exchange(Money money, String changingCurrency) {
    switch (money.getCurrency()) {
      case WON:
        switch (changingCurrency) {
          case "DOLLAR":
            money.setCurrency(Currency.DOLLAR);
            money.setValue(Math.round(money.getValue() / Currency.DOLLAR.getCurrencyValue() * 100) / 100.0);
            break;
          case "YEN":
            money.setCurrency(Currency.YEN);
            money.setValue(Math.round(money.getValue() / Currency.YEN.getCurrencyValue()));
            break;
        }
        break;
      case DOLLAR:
        switch (changingCurrency) {
          case "WON":
            money.setCurrency(Currency.WON);
            money.setValue(
                Math.round(money.getValue() * 100) / 100.0 * Currency.DOLLAR.getCurrencyValue());
            break;
          case "YEN":
            money.setCurrency(Currency.YEN);
            money.setValue(Math.round(money.getValue() * ((double)Currency.DOLLAR.getCurrencyValue()/Currency.YEN.getCurrencyValue())));
            break;
        }
        break;
      case YEN:
        switch (changingCurrency) {
          case "WON":
            money.setCurrency(Currency.WON);
            money.setValue(Math.round(money.getValue() * Currency.YEN.getCurrencyValue()));
            break;
          case "DOLLAR":
            money.setCurrency(Currency.DOLLAR);
            money.setValue(Math.round(money.getValue() /((double)Currency.DOLLAR.getCurrencyValue()/Currency.YEN.getCurrencyValue())));
            break;
        }
        break;
    }
    return money;
  }

  public void printExchanging(){
    System.out.println("환전된 금액은 " + money.getValue() + money.getCurrency().currencyTaste + " 입니다.");
  }
}

