//영수증
public class Receipt {

  public Receipt() {
    this.paymentMoney = 0;
    this.coupon = "";
    this.couponDiscountMoney = 0;
    this.accumulatedMoneyUsed = false;
    this.useAccumulatedMoney = 0;
    this.finalPaymentMoney = 0;
    this.finalMoney = 0;
    this.finalAccmulatedMoney = 0;
  }

  public void setFinalMoney(long finalMoney) {
    this.finalMoney = finalMoney;
  }

  public void setFinalAccmulatedMoney(long finalAccmulatedMoney) {
    this.finalAccmulatedMoney = finalAccmulatedMoney;
  }

  public void setPaymentMoney(long paymentMoney) {
    this.paymentMoney = paymentMoney;
  }

  public void setCoupon(String coupon) {
    this.coupon = coupon;
  }

  public void setCouponDiscountMoney(long couponDiscountMoney) {
    this.couponDiscountMoney = couponDiscountMoney;
  }

  public void setAccumulatedMoneyUsed(boolean accumulatedMoneyUsed) {
    this.accumulatedMoneyUsed = accumulatedMoneyUsed;
  }

  public void setUseAccumulatedMoney(long useAccumulatedMoney) {
    this.useAccumulatedMoney = useAccumulatedMoney;
  }

  public void setFinalPaymentMoney(long finalPaymentMoney) {
    this.finalPaymentMoney = finalPaymentMoney;
  }

  //결제 금액
  long paymentMoney;
  //쿠폰 사용
  String coupon;
  //쿠폰으로 할인 받은 금액
  long couponDiscountMoney;
  //적립금 사용 여부
  boolean accumulatedMoneyUsed;
  //적립금 사용 금액
  long useAccumulatedMoney;
  //최종 금액
  long finalPaymentMoney;
  //잔액
  long finalMoney;
  //적립금
  long finalAccmulatedMoney;
}
