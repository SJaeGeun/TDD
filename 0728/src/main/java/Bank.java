import java.util.Scanner;

public class Bank {
  public static void main(String[] args) {
    ExchangeFee exchangeFee = new ExchangeFee(new Money(Currency.WON, 20000));
    BankService bankService = new BankService();

    Scanner scanner = new Scanner(System.in);
    boolean stop = true;
    while (stop){
      System.out.println("무엇을 하시겠습니까? (1) 입금 (2) 출금 (3) 환전 (4) 종료");
      int check1 = scanner.nextInt();

      switch (check1) {
        case 1:
          System.out.println("얼마를 입금하시겠습니까?");
          double depositValue = scanner.nextDouble();
          bankService.deposit(exchangeFee, depositValue);
          break;
        case 2:
          System.out.println("얼마를 출금하시겠습니까?");
          while (true) {
            double withDrawValue = scanner.nextDouble();
            if (exchangeFee.getMoneyValue() > withDrawValue) {
              bankService.withDraw(exchangeFee, withDrawValue);
              break;
            } else
              System.out.println("금액이 너무 큽니다.");
          }
          break;
        case 3:
          exchangeFee.checkExchange();
          break;
        default:
          stop = false;
      }
    }

  }
}