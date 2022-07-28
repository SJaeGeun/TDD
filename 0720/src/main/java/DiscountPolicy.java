public enum DiscountPolicy implements Coupon {
  /** 10퍼센트 할인 */
  DISPER10(10, 0L) {
    @Override
    public long getDiscountAmt(long originAmt) {
      return originAmt * this.discountRate / 100;
    }
  },
  /** 1000원 할인 */
  DIS1000(0, 1000L) {
    @Override
    public long getDiscountAmt(long originAmt) {
      return this.discountAmt;
    }
  }
  ;
  final int discountRate;
  final long discountAmt;

  DiscountPolicy(int discountRate, long discountAmt) {
    this.discountRate = discountRate;
    this.discountAmt = discountAmt;
  }
}