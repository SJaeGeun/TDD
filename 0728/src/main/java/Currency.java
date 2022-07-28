public enum Currency {
  WON(1,"₩"), DOLLAR(1000, "$"), YEN(10, "¥");

  public int getCurrencyValue() {
    return currencyValue;
  }
  public String getCurrencyTaste() { return currencyTaste; }

  int currencyValue;
  String currencyTaste;

  Currency(int currencyValue, String currencyTaste) {
    this.currencyValue = currencyValue;
    this.currencyTaste = currencyTaste;
  }

}
