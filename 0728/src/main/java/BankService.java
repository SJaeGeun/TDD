public class BankService {

  public void deposit(ExchangeFee exchangeFee, double value) {
    exchangeFee.setMoneyValue(exchangeFee.getMoneyValue() + value);
    System.out.println("현재 금액은 " + exchangeFee.getMoneyValue() + exchangeFee.getMoney().getCurrency().currencyTaste +"입니다.");
  }

  public void withDraw(ExchangeFee exchangeFee, double value) {
    exchangeFee.setMoneyValue(exchangeFee.getMoneyValue() - value);
    System.out.println("현재 금액은 " + exchangeFee.getMoneyValue() + exchangeFee.getMoney().getCurrency().currencyTaste +"입니다.");
  }
}
