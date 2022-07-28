interface Coupon {
  long getDiscountAmt(long originAmt);
  /** 할인없음 */
  Coupon NONE = new Coupon(){
    @Override
    public long getDiscountAmt(long originAmt) {
      return 0;
    }
  };

}
