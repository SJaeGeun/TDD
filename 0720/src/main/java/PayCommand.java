import java.util.Scanner;

public class PayCommand {
  private Customer customer;
  private final double accumulateRate = 0.1;
  private Receipt receipt = new Receipt();
  public PayCommand(Customer customer) {
    this.customer = customer;
  }
  void prepare(Long amount,String customerId){
    receipt.setPaymentMoney(amount);
    Customer.item item = customer.getCustomerItem(customerId);
    //쿠폰 적용 여부
    long couponUsedMoney = ChoiceCoupon(amount);
    //적립금 사용 여부
    long finalAmount = UseAccumulatedMoney(couponUsedMoney, item);
    receipt.setFinalPaymentMoney(finalAmount);
    //적립금을 계산후 customer setter으로 적립금 설정
    item.setAccumulatedMoney(item.getAccumulatedMoney() + (long)(finalAmount * accumulateRate));
    item.setMoney(item.getMoney()-finalAmount);
    receipt.setFinalAccmulatedMoney(item.getAccumulatedMoney());
    receipt.setFinalMoney(item.getMoney());
    receiptPay();
  }

  long UseAccumulatedMoney(Long amount, Customer.item item) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("(1): 적립금 사용 (2): 사용안함");
    int choice = scanner.nextInt();
    long finalAmount;
    switch (choice){
      case 1:
        receipt.setUseAccumulatedMoney(item.getAccumulatedMoney());
        finalAmount = amount - item.getAccumulatedMoney();
        receipt.setAccumulatedMoneyUsed(true);
        item.setAccumulatedMoney(0L);
        break;
      default:
        finalAmount = amount;
        receipt.setAccumulatedMoneyUsed(false);
        receipt.setUseAccumulatedMoney(0L);
        break;
    }
    return finalAmount;
  }

  long ChoiceCoupon(Long amount) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("(1): 10퍼센트 할인 (2): 1000원 할인 (3): 사용안함");
    int choice = scanner.nextInt();
    long couponUsedMoney;
    switch (choice){
      case 1:
        couponUsedMoney = amount - DiscountPolicy.DISPER10.getDiscountAmt(amount);
        receipt.setCouponDiscountMoney(DiscountPolicy.DISPER10.getDiscountAmt(amount));
        receipt.setCoupon("10%");
        break;
      case 2:
        couponUsedMoney = amount - DiscountPolicy.DIS1000.getDiscountAmt(amount);
        receipt.setCouponDiscountMoney(DiscountPolicy.DIS1000.getDiscountAmt(amount));
        receipt.setCoupon("1000원");
        break;
      default:
        couponUsedMoney = amount;
        receipt.setCoupon("할인없음");
        break;
    }
    return couponUsedMoney;
  }

  //영수증
  public void receiptPay(){
    System.out.println("------------------------");
    System.out.println("결제금액 = " + receipt.paymentMoney);
    System.out.println("쿠폰사용 = " + receipt.coupon);
    System.out.println("쿠폰할인금액 = " + receipt.couponDiscountMoney);
    System.out.println("적립금사용금액 = " + receipt.useAccumulatedMoney);
    System.out.println("최종금액 = " + receipt.finalPaymentMoney);
    System.out.println("결제이후 잔액 = " + receipt.finalMoney);
    System.out.println("결제이후 적립금 = " + receipt.finalAccmulatedMoney);
    System.out.println("------------------------");
  }
}

