interface Coupon {
  long getDiscountAmt(long originAmt);
  /** ν μΈμμ */
  Coupon NONE = new Coupon(){
    @Override
    public long getDiscountAmt(long originAmt) {
      return 0;
    }
  };

}
